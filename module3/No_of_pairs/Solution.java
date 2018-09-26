import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for numberof pairs.
 */
class NumberofPairs {
	/**
	 * Constructs the object.
	 */
	NumberofPairs() {
		// default constructor.
	}
	/**
	 * { function_description }.
	 *
	 * @param      arr   The arr
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int Pairs(int[] arr) {
		int count = 1;
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				count++;
			} else {
				temp = temp + (count * (count - 1)) / 2;
				count = 1;
			}
		}
		temp = temp + (count * (count - 1)) / 2;
		return temp;
	}
}
/**
 * "class solution".
*/
public class Solution {
	/**
	 * { main function }.
	 */
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		int[] array = new int[n];
		NumberofPairs np = new NumberofPairs();
		for (int i = 0; i < n; i++) {
			array[i]= s.nextInt();
		}
		Arrays.sort(array);
		System.out.println(np.Pairs(array));
	}
}