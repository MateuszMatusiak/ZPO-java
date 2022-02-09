package main.lab5;

import java.io.*;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.TimerTask;

public class FileWriter extends TimerTask {
    String filename = "";
    char[] buffer;
    final Object checker;
    PrintWriter file;


    public FileWriter(String filename, char[] buffer, Object checker) {
        this.filename = filename;
        this.buffer = buffer;
        this.checker = checker;
    }

    private void handleFile() {
        try {
            file = new PrintWriter(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        handleFile();
        int i = Main.flag;

        while (i < 3) {
            synchronized (checker) {
                if(!Main.canSave)
                {
                    file.print(buffer[0]);
                    Main.canSave = true;
                }
                i = Main.flag;

            }
        }
        file.close();

    }
}