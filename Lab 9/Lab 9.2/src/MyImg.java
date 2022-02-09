import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MyImg implements Serializable {
    int width;
    int height;
    int[][] imgArray;

    public MyImg(BufferedImage img) throws RemoteException {
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.imgArray = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                imgArray[row][col] = img.getRGB(col, row);
            }
        }
    }


    BufferedImage getImage() {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imgArray.length; i++) {
            for (int j = 0; j < imgArray[0].length; j++) {
                int pixel = imgArray[i][j];
                bufferedImage.setRGB(i, j, pixel);
            }
        }
        return bufferedImage;
    }
}
