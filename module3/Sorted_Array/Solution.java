import java.util.Scanner;
/**
 * Class for sorted array.
 */
class SortedArray {
    /**
     * { Integer array1 }.
     */
    private int[] array1;
    /**
     * { Integer array1 }.
     */
    private int[] array2;
    /**
     * Constructs the object.
     *
     * @param      ar1   The archive 1
     * @param      ar2   The archive 2
     */
    SortedArray(final int[] ar1, final int[] ar2) {
        this.array1 = ar1;
        this.array2 = ar2;
    }
    /**
     * { sortArr method }.
     *
     * @param      arra1  The arra 1
     * @param      arra2  The arra 2
     *
     * @return     { description_of_the_return_value }
     */
    public String sortArr(final int[] arra1, final int[] arra2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] list = new int[arra1.length + arra2.length];
        while (i < arra1.length && j < arra2.length) {
            if (arra1[i] < arra2[j]) {
                list[k++] = arra1[i++];
            } else {
                list[k++] = arra2[j++];
            }
        }
        while (i < arra1.length) {
            list[k++] = arra1[i++];
        }
        while (j <= arra2.length) {
            list[k++] = arra2[j++];
        }
        String output = "";
        int a = 0;
        for (a = 0; a < list.length - 1; a++) {
            output += list[a] + ",";
        } output += list[a];
        return output;
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
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        int m = Integer.parseInt(s.nextLine());
        int n = Integer.parseInt(s.nextLine());
        String[] m1 = s.nextLine().split(",");
        String[] n1 = s.nextLine().split(",");
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = Integer.parseInt(m1[i]);
        }
        for (int j = 0; j < n; j++) {
            arr2[j] = Integer.parseInt(n1[j]);
        }
        SortedArray sa = new SortedArray(arr1, arr2);
        System.out.println(sa.sortArr(arr1, arr2));
    }
}
