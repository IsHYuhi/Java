import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.File;


public class SimpleHTTPServer {

  private final int port;

  public SimpleHTTPServer(int port)
  {
    this.port = port;
  }

  public void start() {
    // TODO
    //ServerSocket serverSocket = new ServerSocket(this.port);
    Socket sock = null;//finallyで閉じるためにtry外で宣言
    ServerSocket serverSock = null;
    try {//例外が発生する可能性が非常に高いのでtry/catchブロックを使う 教科書p481
      //サーバプログラムはServerSocketでクライアントからのリクエスト(クライアントでSocketオブジェクトが作られる時に送られる)ものに対応
      serverSock = new ServerSocket(this.port);

      while(true) {
        // 接続を確認したらソケットを作成
        //accept()メソッドはリクエストがあるまで何もしない。リクエストがあれば、クライアントとの通信のためのSocketオブジェクトを戻す
        sock = serverSock.accept();
        Handler handle = new Handler(sock);
        handle.start();

      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      //Socketを閉じる
      try {

        if (sock != null) {
          sock.close();
        }

      } catch (IOException e) {
      }

      // ServerSocketを閉じる
      try {

        if (serverSock != null) {
          serverSock.close();
        }

      } catch (IOException e) {
      }

    }
  }

  private class Handler {
    private final Socket connection;

    Handler(Socket connection) {
      this.connection = connection;
    }

    public void start() throws IOException{

      try{
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));//チェーニグ
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());//チェーニング
        String line;

        if ((line = in.readLine()) != null) {//リクエストライン GET /simplePage.html HTTP/1.1 のような順で入っている。
          //それぞれGET = リクエストメソッド
          // /index.html = リクエストURI
          // HTTP/1.1 = HTTPのバージョン
          System.out.println(line);
          String[] req = line.split(" ");//スペースごとにスプリット
          String reqMethod = req[0];//一単語目

          // GETの場合のみ処理
          if (reqMethod.equals("GET")) {

            String fileName = req[1];//２単語目 filenameに対応
            fileName = fileName.replaceAll("^/", ""); // /を消す
            File file = new File(fileName);
            //System.out.println(fileName);
            byte [] content;
            if(file.exists()){
              //Before sending the file content, you need to prepend an HTTP header that contains information on the content length, the encoding, etc.
              //ファイルコンテンツを送信する前に、コンテンツの長さ、エンコードなどに関する情報を含むHTTPヘッダーを追加する必要がある。
              //template
              content = Files.readAllBytes(file.toPath());//File型をPath型に変換して指定のパスのファイルの中身をバイト列として全部読み込む
            }else{
              File file404 = new File("404.html");
              content = Files.readAllBytes(file404.toPath());//File型をPath型に変換して指定のパスのファイルの中身をバイト列とし
            }
            String headerStr = "HTTP/1.0 200 OK\r\n"
            + "Server: SimpleHTTPServer\r\n"
            + "Content-length: " + content.length + "\r\n"
            + "Content-type: text/html"
            + "; charset=utf-8" + "\r\n\r\n";
            byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));

            // send the header then the content as byte[] via the OutputStream
            out.write(header, 0, header.length);
            out.write(content, 0, content.length);
            //Java言語の System.out では，効率化のため，改行が来るまでデータを内部に溜めておき，改行が来たらまとめて出力するしくみになっています。 そこで，行の途中で強制出力
            out.flush();// 強制出力
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
      return;
    }
  }


  public static void main(String[] args) {
    int port;
    try {
      port = Integer.parseInt(args[0]);
      if (port < 1024 || port > 65535) port = 8080;
    } catch (RuntimeException ex) {
      port = 8080;
    }

    try {
      SimpleHTTPServer server = new SimpleHTTPServer(port);
      server.start();

    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Usage: java SimpleHTTPServer [port]");
    }
  }

}