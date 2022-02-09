import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {

        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(2107);
            registry.rebind("obiektSerwer", new Methods());
            System.out.println("Server started");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
