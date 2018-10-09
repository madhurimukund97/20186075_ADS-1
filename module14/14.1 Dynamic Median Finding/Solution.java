import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for heapsort.
 */
class Heapsort {
	/**
	 * Integer arr type.
	 */
	private int[] arr;
	/**
	 * Integer type size.
	 */
	private int size;
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 *
	 * @param      n     { parameter_description }
	 */
	Heapsort(final int num1) {
		arr = new int[num1];
		size = 0;
	}
	/**
	 * used to insert.
	 * Time complexity is 1.
	 *
	 * @param      item  The item
	 */
	void insert(final int item) {
		arr[size++] = item;
		sort();
	}
	/**
	 * heap sort.
	 * Time complexity is 1.
	 *
	 * @param      num   The number
	 * @param      ind   The ind
	 */
	void heap(int num, int ind) {
		int largest = ind;
		int left = 2 * ind;
		int right = 2 * ind;
		if (left < num && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < num && arr[right] > arr[largest]) {
			largest = right;
		}
		if(largest != ind) {
			swapping(ind, largest);
			heap(num, largest);
		}
	}
	/**
	 * used to sort.
	 * Time complexity is N.
	 */
	void sort() {
		for(int i = (size / 2) - 1; i >= 0; i--){
			heap(size, i);
		}
		for(int i = size - 1; i >= 0; i--){
			swapping(0, i);
			heap(i, 0);
		}
	}
	/**
	 * used to swap.
	 * Time complexity is 1.
	 *
	 * @param      i1    I 1
	 * @param      j1    The j 1
	 */
	void swapping(int i1, int j1) {
		int temp = arr[i1];
		arr[i1] = arr[j1];
		arr[j1] = temp;
	}
	/**
	 * used to get item.
	 * Time complexity is 1.
	 *
	 * @param      ind   The ind
	 *
	 * @return     { description_of_the_return_value }
	 */
	int getitem(int ind) {
		return arr[ind];
	}
	/**
	 * used to get size.
	 * Time complexity is 1.
	 *
	 * @return     { description_of_the_return_value }
	 */
	int getsize() {
		return size;
	}
}
/**
 * Solution class.
 */
final class Solution {
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 */
	private Solution() {
		// constructor not used.
	}
	/**
	 * Client program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		Heapsort hp =  new Heapsort(num);
		for (int i = 0; i < num; i++) {
			hp.insert(Integer.parseInt(s.nextLine()));
			int sz = hp.getsize();
			if ((sz) % 2 == 0) {
				float med = ((float)hp.getitem((sz - 1) / 2) + (float)hp.getitem(sz / 2)) / 2;
				System.out.println(med);
			} else {
				float med = (float)hp.getitem((sz - 1) / 2);
				System.out.println(med);
			}
		}
	}
}
