import javax.swing.*;
import java.awt.event.*;

class GUITest{

  public void changeIt(){
    button.setText("I've been clicked!");
  }

  public static void main(String args[]){
    JFrame frame = new JFrame();//フレーム作成
    JButton button = new JButton("click me");//ボタン作成 引数にテキスト指定

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//windowを閉じるとプログラムが終了する。

    frame.getContentPane().add(button); //ボタンをフレームのコンテンツペーンに組み込む


    frame.setSize(300, 300);// フレームのサイズ指定

    frame.setVisible(true);//GUIが画面に表示される このコードがないと何も表示されない
  }
}

