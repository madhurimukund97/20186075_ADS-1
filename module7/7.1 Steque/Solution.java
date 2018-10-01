import java.util.Scanner;
class Steque {
    /**
     * Node first.
     */
    private Node first = null;
    /**
     * Node last.
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
    public void Listempty() {
        first = null;
        last = null;
    }
	/**
	 * add the elements at end.
	 *
	 * @param      data  The data
	 */
	public void push(int data) {
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
	 * adds the elements at the front.
	 *
	 * @param      data  The data
	 */
	public void enqueue(int data) {
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
	 * pop function (removes the element from last).
	 *
	 * @return     { description_of_the_return_value }
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
	 * Main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfLines = Integer.parseInt(s.nextLine());
		Steque sq = new Steque();
		while (s.hasNext()) {
			String tokens[] = s.nextLine().split(" ");
			switch(tokens[0]) {
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
