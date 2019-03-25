public class CountingValleys {

  public static void main(String[] args) {


  }

  // Complete the countingValleys function below.
  static int countingValleys(int n, String s) {
    int level = 0;
    int valleys = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);

      if (c == 'U')
        level++;
      else {
        level--;
      }

      if (level == 0 && c == 'U')
        valleys++;

    }
    return valleys;

  }


}
