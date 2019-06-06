import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class SwingObjects extends JFrame implements ActionListener{
  private String [] s_item = {"Japan", "USA", "China", "Canada", "Korea", "Russia", "Vietnam"};
  private JComboBox<String> cmb;
  private JRadioButton[] rb = new JRadioButton[s_item.length];
  private JCheckBox[] cb = new JCheckBox[s_item.length];
  private ButtonGroup bg = new ButtonGroup();
  private JLabel lbl = new JLabel();

  @Override
  public void actionPerformed(ActionEvent e){
    String b = "", f="", s="";
    for(int ii = 0; ii< s_item.length; ii++){
      if(rb[ii].isSelected()){
        b = s_item[ii];
      }
      if(cb[ii].isSelected()){
        if(f.length()>0)f += ", ";
        f += s_item[ii];
      }
    }
    if(f.length() <=0){
      f = "no international friends yet";
    }else{
      f = "friends from " + f;
    }
    s = s_item[cmb.getSelectedIndex()];

    String a = "Yes. you were born in "+ b +": ";
    a+= "You have " + f +" and ";
    a += "you are living in " + s + ".";
    lbl.setText(a);
  }
  //constructor
  public SwingObjects(){
    super("swing commenents");
    setSize(625, 225);
    this.setLayout(null);
    Vector<String> tmp = new Vector<String>();
    for(int ii = 0; ii < s_item.length; ii++){
      tmp.add(s_item[ii]);
      rb[ii] = new JRadioButton(s_item[ii]);
      rb[ii].setBounds(100, 5 + 20*ii, 80, 20);
      bg.add(rb[ii]);
      this.add(rb[ii]);
      cb[ii] = new JCheckBox(s_item[ii]);
      cb[ii].setBounds(200, 5 + 20*ii, 80, 20);
      this.add(cb[ii]);
    }


    cmb = new JComboBox<String>(tmp);
    cmb.setBounds(5, 5, 80, 20);
    this.add(cmb);

    JButton btn = new JButton("Do you know me ?");
    btn.addActionListener(this);
    btn.setBounds(300, 5, 200, 20);
    this.add(btn);

    lbl.setBorder(new LineBorder(Color.blue, 3));
    lbl.setBounds(5, 150, 600, 30);
    this.add(lbl);
  }

  public static void main(String[] args){
    SwingObjects o = new SwingObjects();
    o.setVisible(true);
    o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}