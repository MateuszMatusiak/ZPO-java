package main.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main extends Application {
    public static TextArea text1, text2, text3;

    @Override
    public void start(Stage stage) throws IOException {

        //////////////////////

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(text2);

        Scene secondScene = new Scene(secondaryLayout, 450, 250);

        Stage newWindow = new Stage();
        newWindow.setTitle("Plik 2");
        newWindow.setScene(secondScene);

        newWindow.setX(stage.getX() + 200);
        newWindow.setY(stage.getY());

        newWindow.show();
        /////////////////////

        StackPane thirdLayout = new StackPane();
        thirdLayout.getChildren().add(text3);

        Scene thirdScene = new Scene(thirdLayout, 450, 250);

        Stage newestWindow = new Stage();
        newestWindow.setTitle("Plik 3");
        newestWindow.setScene(thirdScene);

        newestWindow.setX(stage.getX() - 200);
        newestWindow.setY(stage.getY());

        newestWindow.show();
        ////////////////////////

        StackPane root = new StackPane();
        root.getChildren().add(text1);
        Scene scene = new Scene(root, 450, 250);

        stage.setTitle("Plik 1");
        stage.setScene(scene);
        stage.show();
//        text1.setDisable(true);
//        text2.setDisable(true);
//        text3.setDisable(true);
    }

    public static int flag = 0;
    public static boolean canSave = true;

    public static void main(String[] args) {
        Random r = new Random();

        int n = r.nextInt(10)+1;
        System.out.println(n);

        if (n <= 5)
            System.out.println("bierz");
        else {
            System.out.println("chuja możesz");
        }
    }
//    public static void main(String[] args) throws IOException {
//        text1=new TextArea();
//        text2=new TextArea();
//        text3=new TextArea();
//        char[] buffer = new char[1];
//        final Object checker = new Object();
//        File file1 = new File("plik1.txt");
//        FileReader f1 = new FileReader(file1, buffer, checker,1);
//
//        File file2 = new File("plik2.txt");
//        FileReader f2 = new FileReader(file2,buffer,checker,2);
//
//        File file3 = new File("plik3.txt");
//        FileReader f3 = new FileReader(file3,buffer,checker,3);
//        FileWriter w1 = new FileWriter("output.txt", buffer,checker);
//
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
//
//        executor.execute(f1);
//        executor.execute(f2);
//        executor.execute(f3);
//        executor.execute(w1);
//        executor.shutdown();
//        launch();
//
//    }
}