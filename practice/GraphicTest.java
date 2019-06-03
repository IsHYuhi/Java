import javax.swing.*;//どちらも必要
import java.awt.*;//graphicsが使える
class GraphicTest extends JPanel {
  public static void main(String args[]){
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    frame.getContentPane().add(panel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
  public void paintComponent(Graphics g){//グラフィックスの表示には不可欠のメソッドで、プログラマが自ら呼び出さず、システムが自動的に呼び出す
    g.setColor(Color.orange);
    g.fillOval(70, 70, 100, 100);
  }
}