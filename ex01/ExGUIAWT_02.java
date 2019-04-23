import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/*
<applet code = "ExGUIAWT_02" width=400 height=300></applet>
*/
public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener{
  private Button btn_minas ;
  private Button btn_plus ;
  protected int count =0;
  protected Label la = new Label(String.valueOf(count));

  public void init(){
    super.init();
    btn_minas = new Button("-");
    btn_plus = new Button("+");
    btn_minas.addActionListener(this);
    btn_plus.addActionListener(this);
    add(btn_minas);
    add(la);
    add(btn_plus);
  }

  public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if(o == btn_minas){
      count--;
    }
    if(o == btn_plus){
      count++;

    }
    this.la.setText(String.valueOf(count));
    repaint();
  }

  public void paint(Graphics g){
    super.paint(g);
  }
}
