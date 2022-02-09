import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface Connector extends Remote {

    String refactorText(String text) throws RemoteException;

    HashMap<String, Integer> makeHistogram(String text) throws RemoteException;
}
