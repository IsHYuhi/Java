import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.File;

public class HTTPServer{
  private final int port;

  public HTTPServer(int port){
    this.port = port;
  }

  public static void main(String[] args ){
    int port;
    try{

      port = Integer.parseInt(args[0]); //ポートを引数にとっていたらそれを代入して
      if(port < 1024 || port >65535)port = 8080;//ウェルノウンポート、ポート番号外だったら8080に指定

    }catch(RuntimeException ex){
      port = 8080;//入力されてなかったら8080
    }

    try{
      HTTPServer http = new HTTPServer(port);
      http.start();
    }catch(ArrayIndexOutOfBoundsException ex){
      System.out.println("error");
    }
  }

  public void start(){
    Socket socket = null;
    ServerSocket serversocket = null;//閉じるためにtry外宣言、null代入

    try{
      serversocket = new ServerSocket(this.port);//ポート指定、指定ポートからのリクエストに対応できるようになる
      while(true){
        socket = serversocket.accept(); // 接続リクエストを待ち、リクエストがきたらオブジェクトを返す

        //////////////////////////////////////
        InputStreamReader stream = new InputStreamReader(socket.getInputStream());
        BufferedReader in = new BufferedReader(stream);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        /////////////////////////////////////
        String line;

        if((line = in.readLine()) != null){
          System.out.println(line);//リクエストラインを表示
          // GET /simplePage.html HTTP/1.1 のような順で入っている。
          //それぞれGET = リクエストメソッド
          // /index.html = リクエストURI
          // HTTP/1.1 = HTTPのバージョン
          String[] req = line.split(" ");//スペースごとにスプリットしてreqに入れる
          String reqMethod = req[0];//GETなどが入っている

          if(reqMethod.equals("GET")){
            String fileName = req[1];
            fileName = fileName.replaceAll("^/", ""); //  /を消す
            File file = new File(fileName);

            byte[] content;
            if(file.exists()){
              content = Files.readAllBytes(file.toPath());//File型をPath型に変換して指定のパスのファイルの中身をバイト列として全部読み込む
            }else{
              File file404 = new File("404.html");
              content = Files.readAllBytes(file404.toPath());
            }

            String headerStr = "HTTP/1.0 200 OK\r\n"
            + "Server: SimpleHTTPServer\r\n"
            + "Content-length: " + content.length + "\r\n"
            + "Content-type: text/html"
            + "; charset=utf-8" + "\r\n\r\n";
            byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));

            out.write(header, 0, header.length);
            out.write(content, 0, content.length);//public void write(byte[] b,int off,int len)throws IOException
            //Java言語の System.out では，効率化のため，改行が来るまでデータを内部に溜めておき，改行が来たらまとめて出力するしくみになっています。 そこで，行の途中で強制出力
            out.flush();// 強制出力
          }
        }
      }//loopend;

    }catch(IOException e){

      e.printStackTrace();

    }finally{

      try{
        if(socket != null)socket.close();
        if(serversocket != null)serversocket.close();
      }catch(Exception ex){
      }

    }
  }

}