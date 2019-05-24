import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerEnv extends Remote {
    String showServerEnv() throws RemoteException;
}
