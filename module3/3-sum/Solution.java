import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for three sum.
 */
class ThreeSum {
    /**
     * { Integer array }.
     */
    private int[] array;
    /**
     * { Integer size }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     * @param      num   The number
     */
    ThreeSum(final int[] arr, final int num) {
        this.array = arr;
        this.size = num;
    }
    /**
     * { count  }.
     *
     * @param      ar    The archive
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int[] ar) {
        Arrays.sort(ar);
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                int res = binarySearch(ar, -(ar[i] + ar[j]));
                if (res > j && res > 0) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * { binary search method }.
     *
     * @param      sarray  The sarray
     * @param      ele     The ele
     *
     * @return     { description_of_the_return_value }
     */
    public int binarySearch(final int[] sarray, final int ele) {
        int first = 0;
        int last = sarray.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (sarray[mid] == ele) {
                return mid;
            } else if (sarray[mid] > ele) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return -1;
    }
}
/**
 *
 * { Solution class }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // constructor not used.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { main }.
         */
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int[] a = new int[n];
        ThreeSum ts = new ThreeSum(a, n);
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(ts.count(a));

    }
}
