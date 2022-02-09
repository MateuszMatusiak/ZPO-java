import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connector extends Remote {
    MyImg rotateImage(File imgFile) throws RemoteException;
}
