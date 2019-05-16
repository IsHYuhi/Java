
// COMPLETE
//
// "Transfer" threads select a random amount of money in [0, max_amount]
// and transfer it to a random account in the bank.
//
import java.util.*;
public class Transfer implements Runnable{
  Random rand = new Random();

  public Transfer(Bank bank, int from, int max_amount) {
    bank_ = bank;
    from_ = from;
    max_ = max_amount;
  }

  public void run(){
    while(true){
      int to = (int)(Math.random()*BankTest.N_ACCOUNTS);//0~N_ACCOUNTS

      this.transaction(to);
    }
  }

  public void transaction(int to_) {
    int amount = (rand.nextInt(this.max_));//0~1000 ここでは2つの方法でランダムを生成している。
    this.bank_.transfer(this.from_, to_, amount);
  }

  private Bank bank_;
  private int from_;
  private int max_;
}