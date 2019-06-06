public class Interleaving{
  public static void main(String[] args){
    ThreadMonitor m = new ThreadMonitor();
    EvenThread t1 = new EvenThread(m);//(1)
    OddThread t2 = new OddThread(m);//(1)
    t1.start();
    t2.start();
  }
}

class EvenThread extends Thread{
  private final ThreadMonitor monitor;
  public EvenThread(ThreadMonitor m){
    monitor = m;
  }

  @Override
  public void run(){
    for(int i = 2; i<=100; i+=2){
      //wait for your trun; print the number; then change the trun
      monitor.waitTurn(2);//2
      System.out.println(i);//3
      monitor.changeTurn();//4
    }
  }
}

class OddThread extends Thread{
  private final ThreadMonitor monitor;
  public OddThread(ThreadMonitor m){
    monitor = m;
  }
  public void run(){
    for(int i = 1; i<=100; i+=2){
      //wait
      monitor.waitTurn(1);//5
      System.out.println(i);//6
      monitor.changeTurn ();//7
    }
  }
}

//synchronization
class ThreadMonitor{
  public static final int ODD = 1;
  public static final int EVEN = 2;

  //hold the current turn(ODD or EVEN)
  private int turn;

  //define a waitTurn() will be used by t1 and t2
  //the argument "old" corresponds to the turn to wait for.
  synchronized public void waitTurn(int old){//8

    try {
      if(turn != old){//一致してなかったら
        turn = (old == ODD) ? EVEN : ODD;//相手にターンを渡して
        wait();//ウエイト
      }
    } catch (InterruptedException e) { }

  }

  //define a method changeTurn() will be used by t1 and t2
  //to indicate it is now the turn for the other thread to run.
  synchronized public void changeTurn(){//8
    System.out.println("changed turn");//13
    // if(turn == ODD)turn = EVEN;
    // else if(turn == EVEN) turn = ODD;
    turn = (turn == ODD) ? EVEN : ODD;//14
    notify();//15
  }

}