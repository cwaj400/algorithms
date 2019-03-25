import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sockmatching {

  public static void main(String[] args) {


  }

  // Complete the sockMerchant function below.
  public static int sockMerchant(int n, int[] ar) {


    int result = 0;

    Set map = new HashSet(n);
    Iterator iterator = map.iterator();

    for (int i = 0; i < n; i++) {
      if (map.contains(ar[i])) {
        result++;
        map.remove(ar[i]);
      } else {
        map.add(ar[i]);
      }
    }

    return result;
  }
}