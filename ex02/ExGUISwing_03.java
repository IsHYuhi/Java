import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExGUISwing_03 extends ExGUISwing_02 implements ActionListener{
  protected JLabel lbl_coner = new JLabel("AM");
  protected String FMChannels[] = {"76.1", "80.0", "81.3", "82.5"};
  protected String AMChannels[] = {"594", "954", "1134", "1242"};
  protected boolean powerOff = true;
  protected boolean CD = true;
  protected boolean FM = false;
  protected int FMIndex = 0;
  protected int AMIndex = 0;
  protected int CDIndex = 0;

  public ExGUISwing_03(String tittle){
    super(tittle);
    lbl_coner.setBounds(10, 10, 25, 20);
    super.jp.add(lbl_coner);
    super.btnToCD.addActionListener(this);
    super.btnToAM.addActionListener(this);
    super.btnToFM.addActionListener(this);
    super.btnUp.addActionListener(this);
    super.btnDown.addActionListener(this);
    super.btnPW.addActionListener(this);
    Reshow();
  }

  public void actionPerformed(ActionEvent actionevent){
    //System.out.println("pushed");
    Object obj = actionevent.getSource();
    if(obj == super.btnPW)
    powerOff = true;
    if(obj == super.btnToCD)
    {
      powerOff = false;
      CD = true;
    }
    if(obj == super.btnToAM)
    {
      powerOff = false;
      CD = false;
      FM = false;
    }
    if(obj == super.btnToFM)
    {
      powerOff = false;
      CD = false;
      FM = true;
    }
    if(obj == super.btnUp)
    if(CD)
    CDIndex++;
    else
    if(FM)
    FMIndex++;
    else
    AMIndex++;
    if(obj == super.btnDown)
    if(CD)
    CDIndex--;
    else
    if(FM)
    FMIndex--;
    else
    AMIndex--;
    Reshow();
  }

  private void Reshow(){
    if(powerOff){
      lbl_coner.setVisible(false);
      super.lbl.setText("Power off");
      btnPW.setEnabled(false);
      super.btnUp.setEnabled(false);
      super.btnDown.setEnabled(false);
      return;
    }

    btnPW.setEnabled(true);
    super.btnUp.setEnabled(true);
    super.btnDown.setEnabled(true);
    if(CD){
      lbl_coner.setVisible(false);
      if(CDIndex <= 0) super.btnDown.setEnabled(false);
      super.lbl.setText("Track"+(CDIndex + 1)+"/20");
      if(CDIndex >= 19) super.btnUp.setEnabled(false);
      return;
    }
    lbl_coner.setVisible(true);
    if(FM){

      lbl_coner.setText("FM");

      if(FMIndex <= 0) super.btnDown.setEnabled(false);
      super.lbl.setText(FMChannels[FMIndex]+"MHz");
      if(FMIndex >= FMChannels.length - 1) super.btnUp.setEnabled(false);
      return;
    }

    lbl_coner.setText("AM");
    if(AMIndex <= 0) super.btnDown.setEnabled(false);
    super.lbl.setText(AMChannels[AMIndex]+"kHz");

    if(AMIndex >= AMChannels.length - 1) super.btnUp.setEnabled(false);

  }

  public static void main(String argv[]){
    JFrame frame = new ExGUISwing_03("ExGUISwing-03");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
