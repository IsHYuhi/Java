import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExGUISwing_01 extends JFrame {

  public ExGUISwing_01(String tittle){
    super.setTitle(tittle);
    this.setSize(400,200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String argv[]){
    JFrame frame = new ExGUISwing_01("ExGUISwing-01");
    frame.setVisible(true);
  }
}
