import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Registry r = LocateRegistry.getRegistry("localhost", 2107);
        Connector c = (Connector) r.lookup("objectServer");
        String path = args[0];
        String res = args[1];

        File imgFile = new File(path);

        try {
            MyImg img2 = c.rotateImage(imgFile);
            BufferedImage result = img2.getImage();
            File outFile = new File(res);
            ImageIO.write(result, "JPG", outFile);
            System.out.println("git");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
