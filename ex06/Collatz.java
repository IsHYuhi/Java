import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

// Collatz conjecture:
// Given n,
// if n is even then divide it by 2,
// if n is odd then multiply it by 3 and add 1,
// The Collatz conjecture claims that this sequence converges to 1.
// This function will return true if the conjecture is verified for
// a given n. False otherwise.
//
// The conjecture can only be false if there is a repeating sequence
// of numbers, excluding 1.
//
// One difficulty is to detect this loop and prevent looping forever.
// We can do it by using a set and marking the numbers as
// we are visiting them.
//
// More on the conjecture:
// https://en.wikipedia.org/wiki/Collatz_conjecture
//
public class Collatz {


  private final static BigInteger TWO = new BigInteger("2");
  private final static BigInteger THREE = new BigInteger("3");


  // Return (true,seq) if n verifies the Collatz conjecture
  // (false,_) otherwise.
  //
  // When Result.valid is true, then Result.sequence will contain
  // the ordered sequence of numbers (which can be used for doing
  // nice plots like on wikipedia).

  public static Result check(BigInteger n) {
    HashSet<BigInteger> visited = new HashSet<BigInteger>();
    ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
    return check(n, visited, sequence);
  }

  public static Result check(BigInteger n, HashSet<BigInteger> visited , ArrayList<BigInteger> sequence) {
    if(n.equals(java.math.BigInteger.ONE)){
      sequence.add(java.math.BigInteger.ONE);
      return new Result(sequence, true);
    }

    if (visited.contains(n)) {
      return new Result(sequence, false);
    }

    visited.add(n);
    sequence.add(n);

    n = (n.mod(TWO).equals(java.math.BigInteger.ZERO)) ? n.divide(TWO) : n.multiply(THREE).add(java.math.BigInteger.ONE);
    return check(n, visited, sequence);
  }


  public static void main(String[] args) {
    System.out.println(args[0]);
    if (args.length != 1) {
      System.out.println("Usage:");
      System.out.println("java Collatz n");
      System.out.println("where n is the number to test");
      System.exit(1);
    }

    BigInteger n = new BigInteger(args[0]);
    Result res = Collatz.check(n);
    System.out.println("Valid for n="+ n.toString());
    System.out.println("Sequence:");
    for (BigInteger s: res.sequence) {
      System.out.print(s + ", ");
    }
    System.out.println();
  }

  public static boolean getResult(BigInteger n) {
    Result res = Collatz.check(n);
    System.out.println("Valid for n="+ n.toString());
    // for (BigInteger s: res.sequence) {
    //   System.out.print(s + ", ");
    // }
    if (res.bool) {
      return true;
    } else { // 反例
      return false;
    }
  }

}

class Result {
  ArrayList<BigInteger> sequence;
  boolean bool = false;
  Result(ArrayList sequence, boolean bool){
    this.sequence = sequence;
    this.bool = bool;
  }
}