import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);    
        int num = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            int count = Integer.parseInt(tokens[0]);
            int rounds = Integer.parseInt(tokens[1]);
            String s = "";
            Dequeue deque = new Dequeue();
            for (int i = 0; i < count; i++) {
                deque.pushBack(i);
            }
            while (!deque.isEmpty()) {
                for (int i = 0; i < rounds - 1; i++) {
                    deque.pushBack(deque.popFront());
                }
                s += deque.popFront() + " ";
            }
            System.out.print(s.substring(0, s.length() - 1));
            System.out.println();
        }
    }
}
