package Main;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
    private final Socket client;
    private final ObjectInputStream is1;
    private final ObjectOutputStream os1;
    HashMap<Integer, Student> studentHashMap = new HashMap<Integer, Student>();


    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        is1 = new ObjectInputStream(client.getInputStream());
        os1 = new ObjectOutputStream(client.getOutputStream());
        initializeStudents();
        timer.schedule(c, 0, 1);
    }

    private void initializeStudents() {
        Student student = new Student("Mateusz", "Matusiak", 228802);
        studentHashMap.put(student.getIndex(), student);

        student = new Student("Jakub", "Zolynski", 231564);
        studentHashMap.put(student.getIndex(), student);

        student = new Student("Rafal", "Sosnowski", 132456);
        studentHashMap.put(student.getIndex(), student);

        student = new Student("Mateusz", "Lebkowski", 185123);
        studentHashMap.put(student.getIndex(), student);

        student = new Student("Wiktor", "Pienkosz", 174825);
        studentHashMap.put(student.getIndex(), student);

        student = new Student("Aleksandra", "Banaszek", 963582);
        studentHashMap.put(student.getIndex(), student);
    }

    TimerTask c = new TimerTask() {
        @Override
        public void run() {
            try {
                while (true) {
                    String cmd = (String) is1.readObject();
                    if (cmd.equals("get")) {
                        Integer index = (Integer) is1.readObject();
                        Student student = studentHashMap.get(index);
                        os1.writeObject(student);
                    } else if (cmd.equals("update")) {
                        Student student = (Student) is1.readObject();
                        if (student == null) {
                            os1.writeObject("There isn't any student");
                            continue;
                        }
                        studentHashMap.putIfAbsent(student.getIndex(), student);
                        studentHashMap.replace(student.getIndex(), student);
                        os1.writeObject("Success");
                        System.out.println("Student updated");
                    } else {
                        os1.writeObject("Bad command");
                    }
                }
            } catch (IOException e) {
                System.out.println("Disconnected");
                c.cancel();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    };
    Timer timer = new Timer();
}
