import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server  {
    public static void main(String[] args) throws RemoteException {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(2107);
            registry.bind("objectServer", new Methods());
            System.out.println("Server started");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
