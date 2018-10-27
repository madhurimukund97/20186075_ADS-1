import java.util.Scanner;
// /**
//  * Class for student.
//  */
// class Student {
//     private int rollnumber;
//     private String name;
//     private double total;
//     Student(int )

// }
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // constructor not used.
    }
    /**
     * main class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        SeparateChainingHashST<Integer, String>
        obj = new SeparateChainingHashST<>();
        SeparateChainingHashST<Integer, Double>
        obj1 = new SeparateChainingHashST<>();
        int number = Integer.parseInt(s.nextLine());
        for (int i = 0; i < number; i++) {
            String[] tokens = s.nextLine().split(",");
            obj.put(Integer.parseInt(tokens[0]), tokens[1]);
            obj1.put(Integer.parseInt(tokens[0]),
                Double.parseDouble(tokens[2]));
        }
        int number1 = Integer.parseInt(s.nextLine());
        MinPQ min = new MinPQ();
        MaxPQ max = new MaxPQ();

        for (int i = 0; i < number1; i++) {
            String[] tok = s.nextLine().split(" ");
            switch (tok[0]) {
                case "BE":
                System.out.println();
                break;
                case "GE":
                System.out.println(max.delMax());
                break;
                case "LE":
                System.out.println(min.delMin());
                break;
                default:
                break;
            }
        }
    }
}
