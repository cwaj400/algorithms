public class Permutation {
  public static void main(String[] args) {
    permutation("ABC");
  }


  static void permutation(String string) {
    permutation(string, "");
  }

  static void permutation(String string, String prefix) {
    if (string.length() == 0) {

      // have concated to prefix
      System.out.println(string);
    } else {

      for (int i = 0; i < string.length(); i++) {

        // 0 to wherever we are + 1 more string.
        String rem = string.substring(0, i) + string.substring(i + 1);
        // Take whatever character we're at and append it to prefix
        permutation(rem, prefix + string.charAt(i));
      }
    }
  }
}
