import java.io.IOException;

public class Example {
  @ToTest
  public Example(){
    int i = 0;
    int j = 0;
    System.out.println("done");
  }

  @ToTest
  public static void testMethod1() {
  }

  @ToTest
  public static void testMethod2() {
    throw new RuntimeException("Test2 should fail");
  }

  @ToTest
  public static void testMethod3() {
    // Test3 should fail
    int a = 1 / 0;
  }

}