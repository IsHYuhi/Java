import java.io.*;
import java.net.*;

class FileReaderClient{
  private final static int BUFSIZE = 20;

  public static void main(String[] args){
    try{
      String fileName;
      long fsize;
      String contents;

      String server = "localhost";
      int port = 1056;

      fileName = args[0];

      Socket s = new Socket(server ,port);//serverNameを入れてる？

      OutputStream os = s.getOutputStream();
      DataOutputStream dos = new DataOutputStream(os);

      dos.writeBytes(fileName);//send the file name to server//ok

      InputStream is = s.getInputStream();
      DataInputStream dis = new DataInputStream(is);
      //System.out.println("1");//ここまでOK
      fsize = dis.readLong();//read file size from the server to the variable fsize;//error
      System.out.println("File Size =" + fsize);
      //System.out.println("2");
      while((contents = dis.readUTF()) != null){
        System.out.println(contents);
      }
      s.close();
    }catch(EOFException e){
      System.out.println("End of File");
    }catch(Exception e){
      System.out.println("Exception: " + e);
    }
  }
}