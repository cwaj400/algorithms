import java.util.HashMap;

public class Fib {
  public static void main(String[] args) {
    System.out.println(fib(10));
  }

  // Super slow fib. Repeated calls.
  static int fib(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }

  // bottom up with no recursion and using DP. Runs in O(n) time.
  static int DPFib(int top) {

    // Mapping element index with fib number.
    HashMap<Integer, Integer> fibMap = new HashMap<Integer, Integer>();

    fibMap.put(0, 0);

    fibMap.put(1, 1);

    for (int i = 2; i <= top; i++) {
      fibMap.put(i, fibMap.get(i - 1) + fibMap.get(i - 2));
    }
    return fibMap.get(top);
  }
}
