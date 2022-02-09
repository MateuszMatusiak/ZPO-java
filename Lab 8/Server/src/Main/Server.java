package Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public Server() {
        runServer();
    }

    private static final ArrayList<ClientHandler> clients = new ArrayList<>();
    public static int PORT = 1234;

    public void runServer() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("Server started");
            while (true) {
                Socket s1 = ss.accept();
                System.out.println("Connected");
                ClientHandler cl = new ClientHandler(s1);
                clients.add(cl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
