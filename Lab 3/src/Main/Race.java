package Main;


import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Race {

    final long simulatedSecondInMillis = 40;
    protected ArrayList<Cyclist> cyclists = new ArrayList<Cyclist>();
    public boolean isEnded = false;
    private int numberOfCyclists = 0;
    private int tp = 0;
    Logger logger = Logger.getLogger(Race.class.getName());


    public Race(Label[] tab, ProgressBar[] tabpb, Label[] top, Label topka) {
        logger.setLevel(Level.FINE);
        ArrayList<String> ch = randomSurnames();
        logger.log(Level.INFO, "Pobrano nazwiska");

        numberOfCyclists = 0;
        Timer timer2 = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TimerTask task2 = new TimerTask() {
                    @Override
                    public void run() {
                        new Thread(() -> {
                            if (numberOfCyclists < 12) {
                                logger.log(Level.INFO, "Dodanie kolarza: " + numberOfCyclists);
                                cyclists.add(new Cyclist(ch.get(numberOfCyclists)));
                                Thread t = new Thread(cyclists.get(numberOfCyclists));
                                ++numberOfCyclists;
                                t.start();
                            }

                        }).start();
                        try {
                            Thread.sleep(60*simulatedSecondInMillis);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                };
                timer2.schedule(task2, 0);


                Platform.runLater(() -> {
                    for (int i = 0; i < numberOfCyclists; ++i) {
                        tab[i].setVisible(true);
                        tab[i].setText(cyclists.get(i).getSurname() + "  " + cyclists.get(i).getTime() + " s");
                        double progress = ((double) cyclists.get(i).getTime() / (double) cyclists.get(i).getFullTime());
                        tabpb[i].setProgress(progress);
                        tabpb[i].setVisible(true);
                        if (tp < 4) {
                            int o = 0;
                            if (cyclists.get(i).isFinished()) {
                                if (tp > 0) {
                                    for (o = 0; o < tp; ++o) {
                                        if ((top[o].getText().equals(cyclists.get(i).getSurname() + "  " + cyclists.get(i).getTime() + " s"))) {
                                            break;
                                        }
                                    }
                                    if (o == tp) {
                                        top[tp].setVisible(true);

                                        top[tp].setText(cyclists.get(i).getSurname() + "  " + cyclists.get(i).getTime() + " s");
                                        tp++;
                                        logger.log(Level.INFO, "Dodanie do topki: " + tp);

                                    }
                                } else {
                                    topka.setVisible(true);
                                    top[tp].setVisible(true);
                                    top[tp].setText(cyclists.get(i).getSurname() + "  " + cyclists.get(i).getTime() + " s");
                                    tp++;
                                    logger.log(Level.INFO, "Dodanie do topki: " + tp);

                                }
                            }
                        }
                    }
                });

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, simulatedSecondInMillis);
        logger.log(Level.INFO, "Przeszedł konstruktor");

    }

    private static ArrayList<String> URLRead() {

        ArrayList<String> surnames = new ArrayList<>();
        try {
            URL xd = new URL("http://szgrabowski.kis.p.lodz.pl/zpo19/nazwiska.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(xd.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                surnames.add(inputLine);
            }
            in.close();
            return surnames;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return surnames;
    }

    private static ArrayList<String> randomSurnames() {
        ArrayList<String> chosen = new ArrayList<>();
        ArrayList<String> surnames = URLRead();
        Random r = new Random();
        String xd = "";
        xd = (surnames.get((Math.abs(r.nextInt())) % surnames.size()));
        chosen.add(xd);

        while (chosen.size() != 12) {
            while (chosen.contains(xd))
                xd = (surnames.get((Math.abs(r.nextInt())) % surnames.size()));
            chosen.add(xd);
        }
        return chosen;
    }


}

