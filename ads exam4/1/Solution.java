import java.util.Scanner;
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
        for (int i = 0; i < number1; i++) {
            String[] tok = s.nextLine().split(" ");
            if (tok[0].equals("get") && tok[2].equals("1")) {
                if (obj.get(Integer.parseInt(tok[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(Integer.parseInt(tok[1]));
                }
            } else if (tok[0].equals("get") && tok[2].equals("2")) {
                if (obj1.get(Integer.parseInt(tok[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(Integer.parseInt(tok[1]));
                }
            }
        }
    }
}
