import java.rmi.Naming;
import java.rmi.RemoteException;

public class CallbackClient {

  public static void main(String args[]) {

    Callback obj = null;
    String message1 = null;
    String message2 = null;

    try {
	    obj = (Callback)Naming.lookup("//" + "/MyCallbackServer");
	    message1 = obj.greeting("JAPANESE");
	    message2 = obj.greeting("ENGLISH");
	} catch (Exception e) {
	    System.out.println("CallbackClient exception: " + e.getMessage());
	    e.printStackTrace();
	}

    System.out.println("Japanese Message = " + message1);
    System.out.println("Enligsh Message = " + message2);

    try {
	    message1 = obj.thanks("JAPANESE");
	    message2 = obj.thanks("ENGLISH");
	} catch (Exception e) {
	    System.out.println("CallbackClient exception: " + e.getMessage());
	    e.printStackTrace();
	}

    System.out.println("Japanese Message = " + message1);
    System.out.println("Enligsh Message = " + message2);


  } // end of main
} // end of CallbackClient