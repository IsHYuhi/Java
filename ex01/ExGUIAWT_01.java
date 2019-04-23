import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/*
<applet code = "ExGUIAWT_01" width=400 height=300></applet>
*/
public class ExGUIAWT_01 extends Applet{
  String messageText = "April 13, 2018";
  Color selectedColor = null;

  public void init(){
    this.setSize(400,300);
  }

  public void paint(Graphics g){
    g.drawString(this.messageText, 155, 150);
    this.selectedColor = Color.red;
    g.setColor(selectedColor);
    g.drawOval(100, 50, 200, 200);
  }
}

