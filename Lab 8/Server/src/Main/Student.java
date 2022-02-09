package Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private final String name;
    private final String surname;
    private final int index;
    private final ArrayList<Double> marks;


    public Student(String name, String surname, int index) {
        this.name = name;
        this.surname = surname;
        this.index = index;
        marks = new ArrayList<>();
    }

    private boolean checkMark(Double mark) {
        for (double i = 2; i <= 5; i += 0.5) {
            if (mark == i)
                return true;
        }
        return false;
    }

    public boolean addMark(Double mark) {
        if (!checkMark(mark)) {
            System.out.println("Bad mark");
            return false;
        } else {
            marks.add(mark);
            return true;
        }
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Student: " + name + " " + surname + " " + index + "\nmarks= " + marks;
    }
}
