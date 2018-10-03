import java.util.Scanner;
/**
 * Class for merge.
 */
class MergeSort{
    /**
     * cutoff to insertion sort.
     */
    final int x = 7;
    /**
     * Constructs the object.
     */
    MergeSort() {
        //Unused Constructor.
    }
    /**
     * merge method.
     * time complexity is N.
     * @param      a  The array
     * @param      aux    The auxiliary
     * @param      l    The low
     * @param      m    The middle
     * @param      h   The high
     */
    public void compareTo(final Comparable[] a, final Comparable[] aux,
        final int l, final int m, final int h) {
        assert isSorted(a, l, m);
        assert isSorted(a, m + 1, h);
        int i = l;
        int j = m + 1;
        for (int k = l; k <= h; k++) {
            if (i > m) {
                aux[k] = a[j++];
            } else if (j > h) {
                aux[k] = a[i++];
            } else if (low(a[j], a[i])) {
                aux[k] = a[j++];
            } else {
                aux[k] = a[i++];
            }
        }
        assert isSorted(aux, l, h);
    }
    /**
     *
     * sort method.
     * @param      a comparable
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort algorithm.
     *to sort array with size less than 7.
     *time complexity is N^2/2
     * @param      a    comparable type.
     * @param      low   The low
     * @param      high  The high
     */
    public void insertion(final Comparable[] a,
        final int l, final int h) {
        for (int ind = l; ind <= h; ind++) {
            for (int jind = ind; jind > l && low(a[jind], a[jind - 1]); jind--) {
                swapping(a, jind, jind - 1);
            }
        }
    }
    /**
     *sorting the elements recursively.
     *time complexity is logN.
     * @param      arr  The array
     * @param      aux    The auxiliary
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(final Comparable[] a, final Comparable[] aux,
        final int l, final int h) {
        if (h <= l + x) {
            insertion(aux, l, h);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int m = (l + h) / 2;
        sort(aux, a, l, m);
        sort(aux, a, m + 1, h);
        if (!low(a[m + 1], a[m])) {
            for (int i = l; i <= h; i++) {
                aux[i] = a[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        compareTo(a, aux, l, m, h);
    }
    /**
     * to String method.
     * Time complexity is n.
     * @param      arr  The array
     *
     * @return    string
     */
    public String print(final Comparable[] arr) {
        String s = "[";
        int k;
        for (k = 0; k < arr.length - 1; k++) {
            s += arr[k] + ", ";
        }
        s += arr[k] + "]";
        return s;
    }
    /**
     * comparing method.
     *
     * @param      i comparable type.
     * @param      j comparable type.
     *
     * @return    boolean.
     */
    public boolean low(final Comparable ind, final Comparable jind) {
        return ind.compareTo(jind) < 0;
    }
    /**
     * Determines if sorted.
     *
     * @param      arr array
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] arr) {
        return isSorted(arr, 1, arr.length - 1);
    }
    /**
     * exchange method.
     * Time complexity is 1.
     *
     * @param      a comparable type
     * @param      i integer
     * @param      j integer
     */
    public void swapping(final Comparable[] arr,
        final int i, final int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * Determines if sorted.
     * Time complexity is n.
     *
     * @param      arr     array
     * @param      l   The low
     * @param      h  The high
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] arr,
        final int l, final int h) {
        for (int k = l + 1; k <= h; k++) {
            if (low(arr[k], arr[k - 1])) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity of thighs method is 1.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * Client Program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        MergeSort ms = new MergeSort();
        while (s.hasNext()) {
            String[] token = s.nextLine().split(",");
            ms.sort(token);
            System.out.println(ms.print(token));
            System.out.println();
        }
    }
}
