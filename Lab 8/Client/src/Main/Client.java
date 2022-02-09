package Main;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    String[] args;
    ObjectInputStream is1;
    ObjectOutputStream os1;
    Student student = null;
    Scanner sc = new Scanner(System.in);
    public static int PORT = 1234;


    public Client(String[] args) {
        this.args = args;
        Socket s1 = null;
        try {
            s1 = new Socket(args[0], PORT);
            System.out.println("Client started");
            os1 = new ObjectOutputStream(s1.getOutputStream());
            is1 = new ObjectInputStream(s1.getInputStream());
            runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleStudent() {
        label:
        while (true) {
            System.out.println("What do you want: add mark; print; leave");
            String cmd = sc.nextLine();
            switch (cmd) {
                case "add mark":
                    System.out.println("Give mark");
                    Double mark = sc.nextDouble();
                    sc.nextLine();
                    if (!student.addMark(mark)) {
                        System.out.println("Bad mark");
                    }
                    break;
                case "print":
                    System.out.println(student);
                    break;
                case "leave":
                    break label;
                default:
                    System.out.println("Bad command");
                    break;
            }
        }
    }

    private void runClient() {
        try {
            while (true) {
                System.out.println("Give command: get; update; exit");
                String cmd = sc.nextLine();
                os1.writeObject(cmd);
                if (cmd.equals("get")) {
                    System.out.println("Give index");
                    Integer index = sc.nextInt();
                    sc.nextLine();
                    os1.writeObject(index);
                    student = (Student) is1.readObject();
                    if (student == null) {
                        System.out.println("Bad index or student doesn't exist");
                        continue;
                    }
                    handleStudent();
                } else if (cmd.equals("update")) {
                    os1.writeObject(student);
                    System.out.println(is1.readObject());
                }else if(cmd.equals("exit"))
                {
                    os1.writeObject(student);
                    System.out.println(is1.readObject());
                    System.exit(0);
                }
                else {
                    System.out.println(is1.readObject());
                }

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
