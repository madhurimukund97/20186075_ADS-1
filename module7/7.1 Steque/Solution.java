import java.util.Scanner;
/**
 * Class for steque.
 * The time complexity is 1.
 */
class Steque {
    /**
     * Node type of first.
     */
    private Node first = null;
    /**
     * Node type of last.
     */
    private Node last = null;
    /**
     * Class for node.
     */
    final class Node {
        /**
         * { data value }.
         */
        private int data;
        /**
         * { next node address }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      num     { set the data to a node }.
         */
        private Node(final int num) {
            data = num;
        }
        /**
         * Gets the data.
         *
         * @return     The data.
         */
        public int gData() {
            return data;
        }
        /**
         * Gets the next.
         *
         * @return     The next.
         */
        public Node gNext() {
            return next;
        }
        /**
         * Sets the next.
         *
         * @param      adrs  The address
         */
        public void sNext(final Node adrs) {
            this.next = adrs;
        }
    }
    /**
     * Makes a listempty.
     */
    public void listempty() {
        first = null;
        last = null;
    }
    /**
     * add the elements at front.
     * The time complexity for push() is 1.
     *
     * @param      data  The data
     */
    public void push(final int data) {
        Node newnode = new Node(data);
        if (first == null) {
            first = newnode;
            last = newnode;
        } else {
            newnode.sNext(first);
            first = newnode;
        }
    }
    /**
     * display the output after push, enqueue and pop operations.
     * Time complexity for display() is n.
     *  
     */
    public void display() {
        Node temp = first;
        String result = "";
        if (first == null) {
            System.out.println("Steque is empty.");
            return;

        }
        while (temp.next != null) {
            result += temp.gData() + ", ";
            temp = temp.gNext();
        }
        result = result + temp.data;
        System.out.println(result);
    }
    /**
     * adds the elements at the end.
     * add the elements at front.
     * The time complexity for enqueue() is 1.
     *
     * @param      data  The data
     */
    public void enqueue(final int data) {
        Node newnode = new Node(data);
        if (first == null) {
            first = newnode;
            last = newnode;
        } else {
            last.sNext(newnode);
            last = newnode;
        }
    }
    /**
     * deletes the eleemnt from begining.
     * Time complexity for pop() is 1.
     * 
     */
    public void pop() {
        if (first == null) {
            return;
        }
        first = first.next;
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
        // Constructor not used.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int numOfLines = Integer.parseInt(s.nextLine());
        Steque sq = new Steque();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
                case "push":
                sq.push(Integer.parseInt(tokens[1]));
                sq.display();
                break;
                case "pop":
                sq.pop();
                sq.display();
                break;
                case "enqueue":
                sq.enqueue(Integer.parseInt(tokens[1]));
                sq.display();
                break;
                default:
                System.out.print("");
                sq = new Steque();
                System.out.println();
                break;
            }
        }
    }
}
