import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for three sum.
 */
class ThreeSum {
    int[] array;
    int size;

    ThreeSum(int[] arr, int num) {
        this.array = arr;
        this.size = num;
    }
    public int count(int[] ar) {
        Arrays.sort(ar);
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i+1; j < ar.length; j++) {
                int res = binarySearch(ar, -(ar[i] + ar[j]));
                if (res > j && res > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int binarySearch(int[] sarray, int ele) {
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
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int a[] = new int[n];
        ThreeSum ts = new ThreeSum(a, n);
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(ts.count(a));

    }
}