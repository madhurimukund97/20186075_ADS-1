import java.util.Scanner;
/**
 * Class for is minimum heap.
 */
class isMinHeap<E extends Comparable<E>> {
	/**
	 * Array of type generic.
	 */
	private E[] minArray;
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 *
	 * @param      arr   The arr
	 */
	isMinHeap(E[] arr) {
		this.minArray = arr;
	}
	/**
	 * low function.
	 * Time complexity is 1.
	 *
	 * @param      a1    A 1
	 * @param      b1    The b 1
	 *
	 * @return     boolean value.
	 */
    public boolean low(final int a1, final int b1) {
        return minArray[a1].compareTo(minArray[b1]) < 0;
    }
	/**
	 * Determines if minimum.
	 * Time complexity is N.
	 *
	 * @return     True if minimum, False otherwise.
	 */
	public  boolean isMinimum() {
		for (int i = 0; i < minArray.length; i++) {
			if (low(i + 1, i)) {
				return false;
			}
		}
		return true;
	}
}
/**
 * Solution class.
 */
public final class Solution {
	/**
	 * Constructs the object.
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
		String dataType = s.nextLine();
		switch (dataType) {
			case "String":
				int num = Integer.parseInt(s.nextLine());
				for (int i = 0; i < num; i++) {
					String[] token = s.nextLine().split(",");
					isMinHeap<String> imh = new isMinHeap<String>(token);
					System.out.println(imh.isMinimum());
				}
			break;
			case "Integer":
				int num1 = Integer.parseInt(s.nextLine());
				for (int i = 0; i < num1; i++) {
					String[] token = s.nextLine().split(",");
					Integer[] inttoken = new Integer[token.length];
					for (int j = 0; j < token.length; j++) {
						inttoken[j] = Integer.parseInt(token[j]);
					}
					isMinHeap<Integer> iimh = new isMinHeap<Integer>(inttoken);
					System.out.println(iimh.isMinimum());
				}
			break;
			case "Float":
				int num2 = Integer.parseInt(s.nextLine());
				for (int i = 0; i < num2; i++) {
					String[] token = s.nextLine().split(",");
					Float[] ftoken = new Float[token.length];
					for (int j = 0; j < token.length; j++) {
						ftoken[j] = Float.parseFloat(token[j]);
					}
					isMinHeap<Float> ifmh = new isMinHeap<Float>(ftoken);
					System.out.println(ifmh.isMinimum());
				}
			break;
			case "Double":
				int num3 = Integer.parseInt(s.nextLine());
				for (int i = 0; i < num3; i++) {
					String[] token = s.nextLine().split(",");
					Double[] dtoken = new Double[token.length];
					for (int j = 0; j < token.length; j++) {
						dtoken[j] = Double.parseDouble(token[j]);
					}
					isMinHeap<Double> idmh = new isMinHeap<Double>(dtoken);
					System.out.println(idmh.isMinimum());
				}
			break;
		}
	}
}
