import java.util.Scanner;

/**
 * node class.
 */
 class Node {
    /**
     * variable data.
     */
 private String data;
 /**
  * variable next.
  */
 private Node next;

 /**
  * constructor.
  * Time complexity is 1.
  *
  * @param      d  The value
  */
  Node(final String d) {
    this.data = d;
 }
 /**
  * Gets the data.
  * Time complexity is 1.
  *
  * @return     The data.
  */
 public String getData() {
    return data;
 }
 /**
  * Gets the next.
  * Time complexity is 1.
  *
  * @return     The next.
  */
 public Node getNext() {
    return next;
 }
 /**
  * Sets the next.
  * Time complexity is 1.
  *
  * @param      n     { next address }
  */
 public void setNext(final Node n) {
    next = n;
 }
 /**
  * Sets the data.
  * Time complexity is 1.
  *
  * @param      s     { the data }
  */
 public void setData(final String s) {
    data = s;
 }
}
/**
 * List of linkeds.
 */
 class LinkedList {
    /**
     * variable first.
     */
    private Node first;
    /**
     * variable size.
     */
    private int size;

    /**
     * constructor.
     * Time complexity is 1.
     */
    LinkedList() {
        first = null;
        size = 0;
    }
    /**
     * insertAt function.
     * Time complexity is 1.
     *
     * @param      pos        The position
     * @param      data       The data
     *
     * @throws     Exception  { exception_description }
     */
    public void insertAt(final int pos,
    final String data) throws Exception {
        if (pos < 0 || pos > size) {
            throw new Exception();
        }
        Node obj = new Node(data);
        // if (pos == 0) {
        //  obj.next = first;
        //  first = obj;
        //  size++;
        //  return;
        // }
        first = insertAt(pos, first, obj, 0);
    }

    /**
     * { function_description }.
     * Time complexity is 1.
     *
     * @param      pos    The position
     * @param      first1  The first
     * @param      obj    The object
     * @param      count  The count
     *
     * @return     { description_of_the_return_value }
     */
    public Node insertAt(final int pos,
    final Node first1, final Node obj, final int count) {
        if (pos == count) {
            obj.setNext(first1);
            size++;
            return obj;
        }
        first1.setNext(insertAt(pos, first1.getNext(), obj, count + 1));
        return first1;
    }

    /**
     * { reverse }.
     * Time complexity is 1.
     */
    public void reverse() {
        reverse(null, first);
    }

    /**
     * { reverse }.
     * Time complexity is 1.
     *
     * @param      pre  The pre
     * @param      curr   The curr
     */
    public void reverse(final Node pre, final Node curr) {
        if (curr != null) {
            reverse(curr, curr.getNext());
            curr.setNext(pre);
        } else {
            first = pre;
        }
    }

    /**
     * { print method }.
     * Time complexity is N.
     */
    public void print() {
        Node temp = first;
        String s = "";
        while (temp != null) {
            s += temp.getData() + ", ";
            temp = temp.getNext();
        }
        System.out.println(s.substring(0, s.length() - 2));
    }
}

/**
 * solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {

    }

    /**
     * main function.
     * Time complexity is N.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (sc.hasNextLine()) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
                case "insertAt":
                try {
                    list.insertAt(Integer.parseInt(token[1]), token[2]);
                    list.print();
            } catch (Exception e) {
                System.out.println("Can't insert at this position.");
            }
                break;
                case "reverse":
                try {
                list.reverse();
                list.print();
            } catch (Exception e) {
                System.out.println("No elements to reverse.");
            }
                default:
                break;
            }
        }
    }
}
