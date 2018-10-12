import java.util.Scanner;
/**
 * Class for taxinumber.
 */
class Taxinumber implements Comparable<Taxinumber> {
	/**
	 * Integer num1.
	 */
	private int num1;
	/**
	 * Integer num2.
	 */
	private int num2;

	/**
	 * Integer sum.
	 */
	private int sum;
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 */
	Taxinumber(int num1, int num2) {
		this.sum = num1 * num1 * num1 + num2 * num2 * num2;
		this.num1 = num1;
		this.num2 = num2;
	}
	public int getnum1() {
		return this.num1;
	}
	public int getnum2() {
		return this.num2;
	}
	public int getsum() {
		return this.sum;
	}
	public int compareTo(Taxinumber t) {
        if (this.sum < t.sum) return -1;
        if (this.sum > t.sum) return +1;
        return 0;
    }
    public String toString() {
        return sum + " = " + num1 + "^3" + " + " + num2 + "^3";
    }
}
/**
 * Solution class.
 */
public final class Solution {
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
		int num = 600;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int res = 0;
        int temp = -1;
        MinPQ<Taxinumber> p = new MinPQ<Taxinumber>();
        for (int i = 0; i <= num; i++) {
            p.insert(new Taxinumber(i, i));
        }
        while (!p.isEmpty()) {
            Taxinumber sn = p.delMin();
            if (temp == sn.getsum()) {
                res++;
            } else {
                res = 0;
            }
            if(res == m - 1) {
                n--;
                if (n == 0) {
                    System.out.println(sn.getsum());
                    break;
                }
            }
            temp = sn.getsum();
            if (sn.getnum2() < num) {
                p.insert(new Taxinumber(sn.getnum1(), sn.getnum2() + 1));
            }
            }
        }	
	
}
