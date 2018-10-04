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
		first = null;
		size = 0;
	}
	public Node insertAt (int ind, Node first, Node ele, int temp) {
		if (ind == temp) {
			ele.next = first;
			size++;
			return ele;
		}
		first.next = insertAt(ind, first.next, ele, temp+1);
		return first;
	}
	public void print() {
		
		Node temp = first;
		while(temp.next != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(temp.data);
		
	}
	public void insertAt(int ind, String data) throws Exception{
		if (ind < 0 || ind > size) {
			throw new Exception();
		}
		Node ele = new Node(data);
		
		first = insertAt (ind, first, ele, 1);
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
				try {
					ll.insertAt(Integer.parseInt(token[1]), token[2]);
					ll.print();
				} catch (Exception e) {
				System.out.println("can't insert at this position");
				}	
				break;
				case "reverse":
				try {
					ll.reverse();
					ll.print();
				} catch (Exception e) {
					System.out.println("No elements to insert.");
				}
				default:
				break;
			}
		}
	}
}