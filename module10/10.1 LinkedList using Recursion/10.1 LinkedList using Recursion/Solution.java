import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * String type of data.
     */
    String data;
    /**
     * Node type next.
     */
    Node next;
    /**
     * Constructs the object.
     *
     * @param      d     String type d.
     */
    Node(String d) {
        this.data = d;
    }
}
/**
 * LinkedList class.
 */
class LinkedList {
    /**
     * Node type first
     */
    Node first;
    /**
     * Integer size.
     */
    int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        first = null;
        size = 0;
    }
    /**
     * Insert at a position.
     * Time complexity is 1.
     *
     * @param      ind    The ind
     * @param      first  The first
     * @param      ele    The ele
     * @param      temp   The temporary
     *
     * @return     { description_of_the_return_value }.
     */
    public Node insertAt (int ind, Node first, Node ele, int temp) {
        if (ind == temp) {
            ele.next = first;
            size++;
            return ele;
        }
        first.next = insertAt(ind, first.next, ele, temp+1);
        return first;
    }
    /**
     * Print method.
     * Time complexity is n.
     */
    public void print() {
        
        Node temp = first;
        String s = "";
        while(temp.next != null) {
            s += temp.data+", ";
            temp = temp.next;
        }
        System.out.println(s.substring(0, s.length() - 2)); 
    }
    /**
     * InsertAt a position method.
     * Time complexity is 1.
     *
     * @param      ind        The ind
     * @param      data       The data
     *
     * @throws     Exception  { exception_description }.
     */
    public void insertAt(int ind, String data) throws Exception {
        if (ind < 0 || ind > size) {
            throw new Exception();
        }
        Node ele = new Node(data);
        
        first = insertAt (ind, first, ele, 1);
    }
    /**
     * reverse of a string.
     * Time complexity is 1.
     *
     * @param      previous  The previous
     * @param      current   The current
     */
    public void reverse(Node pre, Node curr) {
        if (curr != null) {
            reverse(curr, curr.next);
            curr.next = pre;
        } else {
            first = pre;
        }
    }
    /**
     * reverse a list.
     *
     * @throws     Exception  { exception_description }.
     */
    public void reverse() {
        reverse (null, first);
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
