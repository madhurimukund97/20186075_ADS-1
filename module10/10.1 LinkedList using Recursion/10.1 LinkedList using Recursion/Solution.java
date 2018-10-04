import java.util.Scanner;
class Node {
	String data;
	Node next;
	Node(String d) {
		this.data = d;
	}
}
/**
 * LinkedList class.
 */
class LinkedList {
	Node first;
	int size;
	/**
	 * Constructs the object.
	 */
	LinkedList() {
		// first = new Node();
	}
	public void print() {
		
		Node temp = first;
		while(temp.next != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(temp.data);
		
	}
	public void insertAt(int ind, String data) {
		Node newnode = new Node(data);
		Node temp = first;
		if (size == 0) {

		}
		for(int i = 0; i < size - 1; i++){
			temp = temp.next;
		}
		newnode.next = temp.next;
		temp.next = newnode;
		size++;
	}

	public void reverse() {
		return;
	}
}
/**
 * Solution class program.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 * Time complexity of Solution is 1.
	*/
	private Solution() {
		// constructor not used.
	}
	/**
	 * Client program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		while (s.hasNext()) {
			String[] token = s.nextLine().split(" ");
			switch (token[0]) {
				case "insertAt":
					ll.insertAt(Integer.parseInt(token[1]),
						token[2]);
					ll.print();
					break;
				case "reverse":
					ll.reverse();
					break;
				// case "print":
				default:
				break;
			}
		}
	}
}