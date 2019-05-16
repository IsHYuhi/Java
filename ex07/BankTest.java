public class BankTest {
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;


	public static void main(String args[]) {
    //TODO
    Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
    Transfer [] transrunnable = new Transfer[N_ACCOUNTS];
    Thread [] trans = new Thread[N_ACCOUNTS];

    for(int i =0; i<N_ACCOUNTS; i++){
      transrunnable[i] = new Transfer(bank, i, INIT_BALANCE);
    }

    int j = 0;
    for(Transfer r: transrunnable){
      trans[j] = new Thread(r);
      trans[j].start();
      j++;
    }

	}
}
