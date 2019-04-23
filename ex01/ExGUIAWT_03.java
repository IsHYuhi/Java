import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/*
<applet code = "ExGUIAWT_03" width=400 height=300></applet>
*/
public class ExGUIAWT_03 extends ExGUIAWT_02 implements ActionListener, MouseListener, MouseMotionListener{
  int x1,x2;
  int difference = 0;
  public void init(){
    super.init();
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    super.actionPerformed(e);
  }

  public void mousePressed(MouseEvent e){
    x1 = e.getX();
  }

  public void mouseDragged(MouseEvent e){
    x2 = e.getX();
    difference = x2 - x1;
    super.count +=difference;
    super.la.setText(String.valueOf(super.count));
    x1 = x2;
  }

  public void mouseExited(MouseEvent e){
  }
  public void mouseEntered(MouseEvent e){
  }
  public void mouseReleased(MouseEvent e){
  }
  public void mouseMoved(MouseEvent e){
  }
  public void mouseClicked(MouseEvent e){
  }

  public void paint(Graphics g){
    super.paint(g);
  }
}
