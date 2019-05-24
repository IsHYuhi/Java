import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;//サーバー情報のため

public class ServerEnvImpl extends UnicastRemoteObject implements ServerEnv {

  public ServerEnvImpl() throws RemoteException {
    super();
  }

  public String showServerEnv(){
    String OS = System.getProperty("os.name");
    InetAddress address = null;
    try{
      address = InetAddress.getLocalHost();
      address.getHostName();
    }catch(UnknownHostException e){
      e.printStackTrace();
    }
    return "Server Env: OS of "+address.getHostName()+" is "+OS;//ここにでサーバー情報を返す
  }

  public static void main(String args[]) {

    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }
    try {
      ServerEnvImpl obj = new ServerEnvImpl();
      Naming.rebind("//localhost:5555/ServerEnv", obj);//ServerEnvのところがNaming localhost:XXXXとポート指定することもできる
      System.out.println("ServerEnv bound in registry");//出力結果より
    } catch (Exception e) {
      System.out.println("ServerEnvmpl err: " + e.getMessage());
      e.printStackTrace();
    }
  }
}

