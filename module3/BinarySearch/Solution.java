import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int n = input.nextInt();
		int [] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();

		}
		Arrays.sort(array);
		int element = input.nextInt();
		System.out.printf("the nearest element in search index is %d"
			,bisearch(array, 0, n, element));
		System.out.println();

	}
	static int binarysearch(int[] arr, int first, int last, int search) {
		if (first < last) {
			int middle = (first + last) / 2;
			if (arr[middle] == search) {
				int k = middle;
				while (arr[k] == arr[k - 1]) {
					k--;
				}
				return k;
			} else if (search < arr[middle]) {
				return binarysearch(arr, first, middle - 1, search);
			} else {
				return binarysearch(arr, middle + 1, last, search);
			}
		}
		return -1;
	}
}