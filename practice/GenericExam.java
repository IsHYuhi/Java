import java.awt.Point;
import java.util.Vector;

public class GenericExam {
  public static void main(String[] args){
    Vector v = new Vector();
    Vector<Point> v_p = new Vector<Point>();
    Vector<String> v_s = new Vector<String>();

    int i;
    Point p;
    String s;

    //v_s.add(200); //1
    //v_p.add(200); //2
    v.add(200);
    v_s.add("100, 200");
    //v_p.add("100, 200"); //3
    v.add("100, 200");
    //v_s.add(new Point(100, 200)); //4
    v_p.add(new Point(100, 200));
    v.add(new Point(100, 200));

    s = v_s.get(0);
    //p = (Point)v_s.get(0); //5
    //i = (int)v_s.get(0); //6
    //s = (String)v_p.get(0); //7
    p = v_p.get(0);
    //i = (int)v_p.get(0); //8
    //s = (String)v.get(0); //9 //実行時エラー
    //p = (Point)v.get(0); //10 //実行時エラー
    i = (int)v.get(0);//元がint型なのでgetできる。
  }
}
//
// class Point{
//   int x=0, y=0;
//   public Point(int x, int y){
//     this.x = x;
//     this.y = y;
//   }
// }