import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

class ANYBOX<T> implements Iterable<T>{
  private ArrayList<T> array = new ArrayList<T>();

  public void add(T t){
    array.add(t);
  }

  public T get(int i){
    return array.get(i);
  }

  public int getSize(){
    return array.size();
  }

  public Iterator<T> iterator(){
    return new ANYIterator();
  }

  //ANYclassの内部クラス Iterator<T>をインプリメントしてnextやhasNextを作る。
  private class ANYIterator implements Iterator<T>{
    int idx;

    public ANYIterator(){
      idx = 0;
    }

    public boolean hasNext(){
      return (idx<ANYBOX.this.getSize());//外部クラスのインスタンス、メソッドを使える。
    }

    public T next(){
      if(idx >= ANYBOX.this.getSize()){//外部クラスのインスタンス、メソッドを使える。
        //次がなかったとき例外を投げる
        throw new NoSuchElementException();
      }else{
        T next = ANYBOX.this.get(idx);
        idx++;
        return next;
      }
    }
    //とりあえず書く
    public void remove(){
      throw new UnsupportedOperationException();
    }
  }
}

public class IteratorTest{
  //Iterator を用いた全ての要素を出力するメソッド
  public static void showBOX(ANYBOX<? extends ANY> box){
    ANY aox;
    Iterator iterator = box.iterator();
    while (iterator.hasNext()){
      aox = (ANY)iterator.next();
      System.out.println(aox);
    }
  }

  public static void main(String args[]){
    ANYBOX<Things> things = new ANYBOX<Things>();
    Things t1 = new Things("thigs1", 1);
    Things t2 = new Things("thing2", 2);
    things.add(t1);
    things.add(t2);
    showBOX(things);
  }
}


//testクラス
class ANY{
  String name;
  int price;
  public ANY(String n, int p){
    this.name = n;
    this.price = p;
  }

  public String toString(){//これはクラスをそのままプリント文に入れた時にこれが呼び出されて出力される。
    return new String("Name = "+name+", price = "+price);
  }
}

class Things extends ANY{
  public Things(String n, int p){
    super(n,p);
  }
}

class SomeThings extends ANY{
  public SomeThings(String n, int p){
    super(n,p);
  }
}