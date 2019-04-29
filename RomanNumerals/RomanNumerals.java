/**
 * Convert roman numeral to integer. Eg: MCMVII is 2907 EG: IX is 9.
 */
public class RomanNumerals {
  public static void main(String[] s) {

    System.out.println(rn("MCMIV"));

  }

  public static int value(char c) {
    int result = 0;
    switch (c) {
      case 'I':
        result = 1;
        break;
      case 'V':
        result = 5;
        break;
      case 'X':
        result = 10;
        break;
      case 'L':
        result = 50;
        break;
      case 'C':
        result = 100;
        break;
      case 'D':
        result = 500;
        break;
      case 'M':
        result = 1000;
        break;
      default:
        result = -1;
        break;
    }
    return result;
  }

  public static int rn(String s) {
    int result = 0;

    char[] asChars = s.toCharArray();

    for (int i = 0; i < asChars.length; i++) {
      int s1 = value(asChars[i]);

      // at end.
      if (i == asChars.length - 1) {
        result += s1;
        break;
      } else {

        int s2 = value(asChars[i + 1]);

        if (s2 < s1) {
          result += s1;
        } else {
          result = result + s2 - s1;
          i++;
        }
      }
    }


    return result;
  }

}
