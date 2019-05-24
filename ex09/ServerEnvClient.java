import java.rmi.Naming;
import java.rmi.RemoteException;

class ServerEnvClient{
  public static void main(String args[]) {
    String message = "Server: This is my test meaage";

    ServerEnv obj = null;

    try {
      obj = (ServerEnv)Naming.lookup("//localhost:5555" + "/ServerEnv");// //localhost:XXXX
      message = obj.showServerEnv();
    } catch (Exception e) {
      System.out.println("ServerEnvClient exception: " +
      e.getMessage());
      e.printStackTrace();
    }
    System.out.println("Message = " + message);
  } // end of main
}