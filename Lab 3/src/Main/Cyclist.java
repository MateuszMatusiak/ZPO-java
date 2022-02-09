package Main;

import java.util.Random;


public class Cyclist implements Runnable {
private final String surname;
private int time;
private int fullTime;
private boolean isFinished = false;
final int simulatedSecondInMillis = 40;

    public Cyclist(String surname) {
        this.surname = surname;
        this.time=0;
        calculateFullTime();
    }

    @Override
    public void run(){
        while(time<fullTime)
        {
            time++;
            try {
                Thread.sleep(simulatedSecondInMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(time==fullTime) {
            isFinished = true;
        }

    }

    public String getSurname() {
        return surname;
    }

    public int getTime() {
        return time;
    }

    public int getFullTime() {
        return fullTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    void calculateFullTime() {
        Random r = new Random();
        fullTime=(int)(r.nextGaussian()*40+310);
        if(fullTime<250)
            fullTime=250;
        if(fullTime>360)
            fullTime=360;
    }


}
