import java.rmi.Remote;
import java.rmi.RemoteException;

public class  CallbackServer {

  public String sayHello(Callback callback, String lang) throws RemoteException {
    String message = null;

    if(lang.equals("JAPANESE")) {
      message = callback.speakJapanese();
      System.out.println("In CallbackServer, " + message);
      return message;
    } else {
      message = callback.speakEnglish();
      System.out.println("In CallbackServer, " + message);
      return message;

    }
  }
  public String sayThanks(Callback callback, String lang) throws RemoteException {
    String message = null;

    if(lang.equals("JAPANESE")) {
      message = callback.speakJapanese();
      System.out.println("In CallbackServer, " + message);
      return message;
    } else {
      message = callback.speakEnglish();
      System.out.println("In CallbackServer, " + message);
      return message;

    }
  }

}