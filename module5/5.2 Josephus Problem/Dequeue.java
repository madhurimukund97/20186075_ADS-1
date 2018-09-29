import java.util.Scanner;
/**
 * Class for deque.
 */
class Dequeue {
    /**
     * {Variable first of type node}.
     */
    private Node first;
    /**
     * {Variable last of type node}.
     */
    private Node last;
    /**
     * {Variable size of type integer}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable name of type int}.
         */
        private int name;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Dequeue() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (first == null);
    }
    /**
     * {Method to pop an element from the front}.
     *
     * @return     {Integer}
     */
    public int popFront() {
        if (first != null) {
            int item = first.name;
            first = first.next;
            return item;
        }
        return last.name;
    }
    /**
     * Method to push back an element.
     *
     * @param      name  The name
     */
    public void pushBack(final int name) {
        if (last != null) {
            last = new Node();
            last.name = name;
            last.next = null;
            first = last;
        } else {
            Node temp = last;
            last = new Node();
            last.name = name;
            last.next = null;
            temp.next = last;
        }
    }
    /**
     * {Method to get size}.
     *
     * @return     {Integer}
     */
    public int getsize() {
        return size;
    }
}