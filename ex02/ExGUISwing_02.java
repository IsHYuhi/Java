import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ExGUISwing_02 extends ExGUISwing_01{
  protected JButton btnToCD;
  protected JButton btnToAM;
  protected JButton btnToFM;
  protected JButton btnPW;
  protected JButton btnUp;
  protected JButton btnDown;
  protected JPanel pnlDisplay;
  // protected JButton[] button = new JButton[6];
  // protected String [] name = {"PW","AM","FM","CD","Up","Down"};
  protected Border border = new BevelBorder(BevelBorder.LOWERED, Color.white, Color.gray);
  protected JLabel lbl;
  protected JPanel jp = new JPanel();

  public ExGUISwing_02(String tittle){

    super(tittle);
    this.setSize(355,145);

    Container cont = this.getContentPane();
    jp.setLayout(null);
    cont.setLayout(null);

    //ボタンがなぜか四角くなってしまうのでEx03の情報を元に配列から単体へ変更した。

    // for(int i = 0; i <6; i++){
    //   JButton bt = new JButton(name[i]);
    //   bt.setSize(60,20);
    //   if(i<3){
    //     bt.setLocation(10,i*40+5);
    //   }else{
    //     bt.setLocation(280,(i-3)*40+5);
    //   }
    //   button[i] = bt;
    //   cont.add(button[i]);
    // }

    btnToCD = new JButton("CD");
    btnToAM = new JButton("AM");
    btnToFM = new JButton("FM");
    btnPW = new JButton("PW");
    btnUp = new JButton("Up");
    btnDown = new JButton("Down");
    getContentPane().setLayout(null);
    btnToCD.setBounds(280, 5, 70, 30);
    add(btnToCD);
    btnToAM.setBounds(2, 45, 70, 30);
    add(btnToAM);
    btnToFM.setBounds(2, 85, 70, 30);
    add(btnToFM);
    btnPW.setBounds(2, 5, 70, 30);
    add(btnPW);
    btnUp.setBounds(280, 45, 70, 30);
    add(btnUp);
    btnDown.setBounds(280, 85, 70, 30);
    add(btnDown);


    jp.setBorder(border);
    jp.setLocation(75,2);
    jp.setSize(200, 105);
    cont.add(jp);

    lbl = new JLabel("Power off");
    lbl.setFont(new Font("Arial", Font.BOLD, 32));
    lbl.setForeground(new Color(0, 128, 0));
    lbl.setBounds(25, 50, 170, 40);
    jp.add(lbl, BorderLayout.CENTER);

  }

  public static void main(String argv[]){
    JFrame frame = new ExGUISwing_02("ExGUISwing-02");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
