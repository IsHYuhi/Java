import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/*
<applet code = "ExGUIAWT_01" width=400 height=400></applet>
*/
public class example extends Applet implements ActionListener{
  private Button btn_r ;
  private Button btn_b ;
  private String messageText = "No Color Selected!";
  Color selectedColor = null;

  public void init(){
    btn_r = new Button("Red");
    btn_b = new Button("Blue");
    btn_r.addActionListener(this);
    btn_b.addActionListener(this);
    add(btn_r);
    add(btn_b);
  }

  public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if(o == btn_r){
      selectedColor = Color.red;
      messageText = "Red button selected!";
    }
    if(o == btn_b){
      selectedColor = Color.blue;
      messageText = "Blue button selected!";
    }
    repaint();
  }

  public void paint(Graphics g){
    if(selectedColor != null){
      g.setColor(selectedColor);
    }
    g.drawString(messageText, 20, 200);
  }
}

