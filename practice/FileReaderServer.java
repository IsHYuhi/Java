import java.io.*;
import java.net.*;

//FIle Reader ServerSocket
class FileReaderServer{
  private final static int BUFSIZE = 20;

  public static void main(String[] args){
    String fileName;
    long fsize;
    String contents;

    try{
      int port = 1056;

      ServerSocket ss = new ServerSocket(port);

      while(true){
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        //InputStreamReader is = InputStreamReader(s.getInputStream());
        DataInputStream dis = new DataInputStream(is);
        fileName = dis.readLine();//to read file name that client sent.
        File file = new File(fileName);
        fsize = file.length();
        System.out.println("Providing cntents of the file (" +fileName+"), Size = "+fsize);

        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeLong(fsize);
        //ここまでOK
        BufferedReader charStream = new BufferedReader(new FileReader(file));
        while((contents = charStream.readLine())!= null){
          //System.out.println(contents);
          dos.writeUTF(contents);//ここでエラー
        }
        s.close();
      }
    }catch(Exception e){
      System.out.println("Exception: " + e);
    }
  }


}