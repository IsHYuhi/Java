import javax.swing.*;
import java.awt.event.*;
import java.awt.*;//graphicsが使える
class EventTest {//内部クラスでインプリメントするためActionListenerはインプリメントしない
  JButton button;
  JButton button2;
  JFrame frame;
  Color c = Color.orange;
  int x, y;
  public static void main(String args[]){
    EventTest event = new EventTest();
    event.go();
  }

  public void go(){
    frame = new JFrame();
    frame.setTitle("Test_Programing");
    
    button = new JButton("click me");
    button2 = new JButton("Change color");
    GraphicTest panel = new GraphicTest();
    //イベントリスナーを登録 ボタンのリスナーリストにリスナーが追加される。

    //引数には、ActionListenerインターフェースをインプリメントするオブジェクトへの参照を指定
    button.addActionListener(new ButtonListener());
    button2.addActionListener(new ColorListener());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//閉じたら終了する

    frame.getContentPane().add(BorderLayout.SOUTH, button);//ボタンをクリックしたらテキストが変わるボタン
    frame.getContentPane().add(BorderLayout.NORTH, button2);//グラフィックの色を変えるボタン
    frame.getContentPane().add(panel);//グラフィック

    frame.setSize(300, 300);

    frame.setVisible(true);

    for(int i =0; i<130; i++){
      x++;
      y++;
      panel.repaint();
      try{
        Thread.sleep(50);
      }catch (Exception ex){
      }
    }
  }
  //内部クラスイベントリスナーをインプリメントする
  class ButtonListener implements ActionListener{
    //ActionListenerインターフェースのactionPerformed()をインプリメントする。実際のイベント処理はこのメソッドで行われる
    public void actionPerformed(ActionEvent e){
      button.setText("I've been clicked");
    }
  }

  class ColorListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      c = Color.red;
      frame.repaint();//外部クラスのインスタンスだが内部クラスでも使用できる。
    }
  }
  class GraphicTest extends JPanel {
    public void paintComponent(Graphics g){//グラフィックスの表示には不可欠のメソッドで、プログラマが自ら呼び出さず、システムが自動的に呼び出す
      g.setColor(Color.white);
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
      g.setColor(c);
      g.fillOval(x, y, 40, 40);
    }
  }
}
