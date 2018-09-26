import java.util.Scanner;
/**
 * Class for sorted array.
 */
class SortedArray {
	private int[] array1;
	private int[] array2;
	/**
	 * Constructs the object.
	 */
	SortedArray(final int[] ar1, final int[] ar2) {
		this.array1 = ar1;
		this.array2 = ar2;
	}
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
        while (j < arra2.length) {
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
        for (int i = 1; i < m; i++) {
            arr1[i] = Integer.parseInt(m1[i]);
        }
        for (int j = 0; j < n; j++) {
            arr2[j] = Integer.parseInt(n1[j]);
        }
        SortedArray sa = new SortedArray(arr1, arr2);
        System.out.println(sa.sortArr(arr1, arr2));
    }
}