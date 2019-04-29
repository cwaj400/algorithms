import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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


  /*
   * Complete the function below.
   1. First sort chars.
   2. Make sure all letters are present.
   3. Return minimum count of letters.
   */
  static int differentTeams(String skills) {
    boolean gotB = false;
    boolean gotZ = false;
    boolean gotC = false;
    boolean gotM = false;
    boolean gotP = false;

    int numberOfB = 0;
    int numberOfC = 0;
    int numberOfM = 0;
    int numberOfP = 0;
    int numberOfZ = 0;

    //Convert to array of chars.
    char tempSortedArray[] = skills.toCharArray();
    //Sort array of chars.
    Arrays.sort(tempSortedArray);
    //Make sure all chars are there.
    for (Character character : tempSortedArray) {
      switch(Character.toLowerCase(character)) {
        case 'b': gotB = true;
          break;

        case 'c': gotC = true;
          break;

        case 'm': gotM = true;
          break;

        case 'p': gotP = true;
          break;

        case 'z': gotZ = true;
          break;

        default:
          break;
      }
    }

    if (gotB && gotC && gotM && gotP && gotZ) {
      for (int i = 0; i < tempSortedArray.length; i++) {
        switch(Character.toLowerCase(tempSortedArray[i])) {
          case 'b':
            numberOfB = numberOfB + 1;
            break;

          case 'c':
            numberOfC = numberOfC + 1;
            break;

          case 'm':
            numberOfM = numberOfM++;
            break;

          case 'p':
            numberOfP = numberOfP++;
            break;

          case 'z':
            numberOfZ = numberOfZ++;
            break;

          default :
            break;
        }
      }
    }

    return Math.min(numberOfB, Math.min(numberOfC, Math.min(numberOfM, Math.min(numberOfP, numberOfZ))));
  }


}
