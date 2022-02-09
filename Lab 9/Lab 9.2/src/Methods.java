import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Methods extends UnicastRemoteObject implements Connector {
    public Methods() throws RemoteException {
        super();
    }

    @Override
    public MyImg rotateImage(File imgFile) throws RemoteException {
        BufferedImage img = null;
        try {
            img = ImageIO.read(imgFile);

        int w = img.getWidth();
        int h = img.getHeight();
        int[] buff = new int[w * h];
        img.getRGB(0, 0, w, h, buff, 0, w);
        BufferedImage img2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        img2.setRGB(0, 0, w, h, buff, 0, w);

        Graphics2D g = img2.createGraphics();
        g.translate((h - w) / 2, (h - w) / 2);
        g.rotate(Math.PI / 2, h / 2, w / 2);
        g.drawRenderedImage(img, null);


        return new MyImg(img2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
