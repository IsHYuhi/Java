import java.math.BigInteger;
import java.util.Date;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatzMT n num_threads");
      System.out.println("where positive integers i: 1<= i <= n will be checked");
      System.out.println("and num_threads is the number of threads to use");
      System.exit(1);
    }

    // TODO complete
    // Spawn num_threads,
    // each of them will verify the conjecture for i in [lower, upper]
    // where lower and upper are determined such that each thread has
    // approximately the same amount of work to perform.
    //
    BigInteger maxN = new BigInteger(args[0]);
    int NumberOfThread = Integer.parseInt(args[1]);
    int range = maxN.divide(new BigInteger(String.valueOf(NumberOfThread))).intValue();//maxをスレッドの数で分割
    CollatzRunnable[] runnable = new CollatzRunnable[NumberOfThread];
    Thread [] thread = new Thread[NumberOfThread];

    for(int i = 0; i<NumberOfThread; i++){
      runnable[i] = new CollatzRunnable(new BigInteger(String.valueOf(i*range)), new BigInteger(String.valueOf((range)*(i+1))));
    }

    long start_time = new Date().getTime();

    int j = 0;
    for(CollatzRunnable r : runnable){
      thread[j] = new Thread(r);
      thread[j].start();
      j++;
    }

    //joinで全てのスレッドが終わるのを待つ。
    try {
      for (int i = 0; i < NumberOfThread; i++) {
        thread[i].join();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }


    boolean bool = true;
    for (int i = 0; i < NumberOfThread; i++) {
      if (!runnable[i].bool) {
        //System.out.println(runnable[i].bool+", "+(i+1));
        bool = false;//一つでもfalseがあればfalse
      }
    }

    long end_time = new Date().getTime();
    System.out.println("Ellapsed time: " + (end_time - start_time) + "ms");
    if(bool){
      System.out.println("success");
    }else{
      System.out.println("error");
    }

  }
}
class CollatzRunnable implements Runnable{
  BigInteger min;
  BigInteger max;
  boolean bool = true;

  CollatzRunnable(BigInteger min, BigInteger max){
    this.min = min;
    this.max = max;
  }
  public void run() {
    BigInteger n = this.max;
    while (n.compareTo(this.min) > 0) {//max~min
      boolean res = Collatz.getResult(n);
      if (!res) {
        this.bool = false;
        break;
      }
      n = n.subtract(BigInteger.ONE);//n--
    }

  }

}