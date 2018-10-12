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
     *
     * @param      num11  The number 1
     * @param      num22  The number 2
     */
    Taxinumber(final int num11, final int num22) {
        this.sum = num11 * num11 * num11 + num22 * num22 * num22;
        this.num1 = num11;
        this.num2 = num22;
    }
    /**
     * get method for num1.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnum1() {
        return this.num1;
    }
    /**
     * get method for num2.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnum2() {
        return this.num2;
    }
    /**
     * getsum.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getsum() {
        return this.sum;
    }
    /**
     * compareTo.
     * Time complexity is 1.
     *
     * @param      t     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Taxinumber t) {
        if (this.sum < t.sum) {
            return -1;
        } else if (this.sum > t.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     *
     * @return     String representation of the object.
     */
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
        final int num = 1300;
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
            if (res == m - 1) {
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
