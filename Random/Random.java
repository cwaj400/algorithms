import sun.jvm.hotspot.utilities.Hashtable;

import java.util.HashSet;
import java.util.Set;

class Random {
  public static void main(String[] args) {
//    System.out.println(factorial(4));

    allFib(9);
    allFibFaster(9);

    int[] ints = new int[]{1, 2, 19, 20, 5, 10, 4};

    System.out.println(binarySearch(ints, 0, ints.length, 10));

  }


  /**
   * Runs in O(n) time. Going down from n, n - 1, n - 2 etc
   *
   * @param n input.
   *
   * @return computes n!;
   */
  static float factorial(float n) {

    if (n < 0) {
      return -1;
    } else if (n == 0) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }


  /**
   * allFib - prints all Fib numbers from 0 to n 2^n runtime.
   */
  static void allFib(int n) {
    long startTime = System.nanoTime();
    for (int i = 0; i < n; i++) {
      System.out.println(i + ": " + fib(i));
    }
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println("\nTime: " + totalTime + "\n");
  }

  static int fib(int n) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  /**
   * Faster fib using memoization. O(n) time.
   */

  static void allFibFaster(int n) {
    long startTime = System.nanoTime();
    int[] memo = new int[n + 1];
    for (int i = 0; i < n; i++) {
      System.out.println(i + ": " + fib(i, memo));
    }
    long endTime = System.nanoTime();
    long totalTime = startTime - endTime;
    System.out.println("\nTime: " + totalTime + "\n");
  }

  static int fib(int n, int[] memo) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (memo[n] > 0) {
      return memo[n];
    }

    memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    return memo[n];
  }

  static int binarySearch(int[] array, int first, int last, int element) {
    if (last >= first) {
      int mid = first + (last - first) / 2;
      if (element == array[mid]) {
        return array[mid];
      }
      if (element > array[mid]) {

        // Search right.
        return binarySearch(array, (first + 1), last, element);
      } else {

        // Search left.
        return binarySearch(array, first, mid - 1, element);
      }
    }

    // not here
    return -1;
  }

  /**
   * Implement an algorithm to determine if a string has all unique characters.
   */
  static boolean isUnique(String input) {
    Set set = new HashSet<Character>();
    for (char c : input.toCharArray()) {
      set.add(c);
    }
    return set.size() == input.length();
  }

  /**
   * Implement an algorithm which determines if two strings are permutations of each other.
   */
  static boolean perm(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    return sort(s1).equals(sort(s2));
  }

  static String sort(String s) {
    char[] charArray = s.toCharArray();
    java.util.Arrays.sort(charArray);
    return new String(charArray);
  }

  /**
   * Calculate how many ways one can reach the top step (n), when one can take 1, 2 or 3 steps at a
   * time.
   *
   * @param n
   *
   * @return
   */
  public int howMany(int n) {
    if (n <= 0 || n == 1) {
      return n;
    } else {
      return howMany(n - 1) + howMany(n - 2) + howMany(n - 3);
    }
  }
}
