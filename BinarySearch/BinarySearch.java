import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
  public static void main(String[] args) {

    int array[] = new int[]{3, 4, 6, 8, 9};
    int el = 8;
    int left = 0;
    int right = array.length - 1;

    //should return 3.
    System.out.println(binarySearch(el, left, right, array));

    System.out.println(itBinarySearch(el, array));

  }


  /**
   * Compare element with array[n/2], if element > n/2, search top half. If element < n/2, search
   * bottom half.
   */
  // return where in array element is. n is size of array.
  static int binarySearch(int element, int low, int high, int[] array) {

    if (high >= low) {
      // 3 = left. 5 = right.
      int mid = low + ((high - low) / 2);

      if (array[mid] == element) {
        return mid;
      }

      // Search left side of middle.
      if (array[mid] > element) {
        return binarySearch(element, low, mid - 1, array);
      }

      // Search right side of middle.
      return binarySearch(element, mid + 1, high, array);

    }
    // else not here.
    return -1;
  }


  static int itBinarySearch(int element, int[] array) {
    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) / 2);

      if (array[mid] == element) {
        return mid;
      }
      if (array[mid] < element) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
