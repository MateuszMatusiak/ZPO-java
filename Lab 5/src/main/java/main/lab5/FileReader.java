package main.lab5;

import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.TimerTask;

public class FileReader extends TimerTask {
    File file;
    char[] buf;
    int x;
    BufferedReader buffer;
    final Object checker;
    int fileNumber;

    public FileReader(File file, char[] buffer, Object checker, int fileNUmber) {
        this.file = file;
        this.buf = buffer;
        this.checker = checker;
        this.fileNumber = fileNUmber;
    }

    public void handleFile() {
        try {
            InputStream in = new FileInputStream(file);
            InputStreamReader r = new InputStreamReader(in, Charset.defaultCharset());
            buffer = new BufferedReader(r);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readCharacter(BufferedReader buffer) throws IOException, InterruptedException {
        if (Main.canSave) {
            if ((x = buffer.read()) != -1) {
                char c = (char) x;
                if (buf[0] == c) {
                    Main.canSave = true;
                } else {
                    buf[0] = c;
                    Main.canSave = false;
                }
            }
        }
    }

    private void writeInWindow() throws InterruptedException {
        if (fileNumber == 1) {
            if (!Main.canSave) {
                Main.text1.setText(Main.text1.getText() + buf[0]);
            }
        }
        if (fileNumber == 2) {

            if (!Main.canSave) {
                Main.text2.setText(Main.text2.getText() + buf[0]);
            }
        }
        if (fileNumber == 3) {
            if (!Main.canSave) {
                Main.text3.setText(Main.text3.getText() + buf[0]);
            }
        }
    }

    @Override
    public void run() {
        handleFile();
        while (x != -1) {
            synchronized (checker) {
                try {
                    readCharacter(buffer);
                    if (!Main.canSave)
                        writeInWindow();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (checker) {
            Main.flag++;
        }

    }
}