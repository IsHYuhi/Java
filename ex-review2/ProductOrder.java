import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


class SortableDataStore  implements Comparable<SortableDataStore> {
  protected String productItem, noItem, orderInfo;
  public SortableDataStore() {
    productItem = null;
    noItem = null;
    orderInfo = null;
  }
  public SortableDataStore(String p, String n, String o) {
    this.productItem =p;
    this.noItem =n;
    this.orderInfo = o;
  }
  public String toString() {
    // fill in the area
    return new String(productItem + ", " + noItem + ", " + orderInfo) ;
  }

  public int compareTo(SortableDataStore v){
    if((productItem.compareTo(v.productItem))!=0) return productItem.compareTo(v.productItem);
    if(Integer.parseInt(noItem) < Integer.parseInt(v.noItem)) return -1;
    else if(Integer.parseInt(noItem) > Integer.parseInt(v.noItem)) return 1;
    return 0;
  }

} // end of DataStore

/******
This provides only the sample code for Java GUI shape.
You should fill in all the code for envent handling and other operation.
*****/
public class ProductOrder extends JFrame implements ActionListener{
  protected String list_Contents, noOrder, orderInfo;
  protected SortableDataStore[] v = new SortableDataStore[20];

  protected JPanel topp, leftp, rightp,bottomp,centerup, centerdown;
  protected JButton putb, showb, sortb, clearb;
  protected JLabel title, noorder, orderinfo;
  protected JList plist;
  protected JTextField nofield, infofield;
  protected JTextArea contentsarea;
  protected String[] data = {"IBM NoteBook", "Dell Product", "MS Windows", "Sun Workstation", "Oracle DB", "MySQL"};
  protected int idx = 0;
  protected int lastIndex = -1;

  public ProductOrder(){
    getContentPane().setLayout(new BorderLayout());
    topp = new JPanel();
    leftp = new JPanel();
    rightp = new JPanel();
    bottomp = new JPanel();
    centerup = new JPanel();
    centerdown = new JPanel();

    getContentPane().add(topp, "North");
    getContentPane().add(leftp, "West");
    getContentPane().add(rightp, "Center");
    getContentPane().add(bottomp, "South");

    title = new JLabel("Product Order");
    title.setFont(new Font("Product Order",Font.BOLD, 20));
    topp.add(title);

    plist = new JList(data);
    plist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//まだ見てない。
    plist.addListSelectionListener(new ProductItemListener()); //done
    leftp.add(plist);

    noorder = new JLabel("No. of Order Items");
    orderinfo = new JLabel("Order Information");
    nofield = new JTextField();
    infofield = new JTextField();

    putb = new JButton("Put into Cart");
    putb.addActionListener(new PutButtonListener()); //done
    sortb = new JButton("Sort Items");
    sortb.addActionListener(new SortButtonListener());//done
    clearb = new JButton("Reset Cart");
    clearb.addActionListener(new ResetButtonListener());//done

    centerup.setLayout(new GridLayout(2,2));
    centerup.add(noorder);
    //入力フォーム
    centerup.add(orderinfo);
    centerup.add(nofield);
    centerup.add(infofield);

    centerdown.setLayout(new GridLayout(1,2));
    centerdown.add(putb); //put into cart button
    centerdown.add(sortb); // sort items button
    centerdown.add(clearb); //reset cart

    rightp.setLayout(new GridLayout(2,1));
    rightp.add(centerup); //入力フィールド追加
    rightp.add(centerdown); //3つのボタンを追加

    showb = new JButton("Show Cart");
    showb.addActionListener(new ShowButtonListener());//done


    contentsarea = new JTextArea(10,1); //コンテンツの中身を表示する
    bottomp.setLayout(new GridLayout(1,2));
    bottomp.add(showb);    //showボタンをボトムに追加
    bottomp.add(contentsarea);  //コンテンツの表示をボトムに追加

  }  // Product Order constructor



  //
  public void actionPerformed(ActionEvent e){

  }


  /*****
  Fill in code for event listeners.
  You can use inner classes for the listeners.
  *****/

  class ProductItemListener implements ListSelectionListener{
    public void valueChanged(ListSelectionEvent e){
      if (e.getValueIsAdjusting()) {
        // The user is still manipulating the selection.
        return;
      }
      Object obj = plist.getSelectedValue();
      if (obj != null) {
        list_Contents =  obj.toString();
      }

    }
    public ProductItemListener(){
      super();
    }
  }

  class PutButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      noOrder = nofield.getText();
      orderInfo = infofield.getText();
      v[idx++] = new SortableDataStore(list_Contents, noOrder, orderInfo);// list_Contentsには選択したコンテンツが入っている。
    }
    public PutButtonListener(){
      super();
    }
  }

  class SortButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(idx ==0) return;
      Arrays.sort(v, 0, idx);
      contentsarea.setText("");
      for(int i = 0; i<idx; i++){
        contentsarea.append((v[i].toString()+"\n"));
      }
    }
    SortButtonListener(){
      super();
    }
  }

  class ResetButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      idx = 0;
      contentsarea.setText("");
    }

    public ResetButtonListener(){
      super();
    }
  }

  class ShowButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      contentsarea.setText("");
      for(int i = 0; i<idx; i++){
        contentsarea.append((v[i].toString()+"\n"));
      }
    }
    public ShowButtonListener(){
      super();
    }
  }

  //main
  public static void main (String args[]) {
    ProductOrder f = new ProductOrder();
    f.setTitle("Product Order");
    f.setSize(500,400);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

} // end of ProductOrder

