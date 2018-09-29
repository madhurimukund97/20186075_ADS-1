import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    String data;
    Node next;
}
/**
 * List of linkeds.
 */
class LinkedList {
    Node start;
    int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        start = new Node();
        size = 0;
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     */
    void insert(String item) {
        Node obj = new Node();
        obj.data = item;
        if (size == 0) {
            start = obj;
            size++;
            return;
        }
        obj.next = start;
        start = obj;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String delete() {
        String data = start.data;
        start = start.next;
        size--;
        return data;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        if(size == 0) {
            return true;
        }
            return false;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    int size() {
        return size;
    }
}
/**
 * List of .
 */
class Stack {
    /**
     * { var_description }.
     */
    LinkedList stckll;
    /**
     * Constructs the object.
     */
    Stack() {
        stckll = new LinkedList();
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    void push(String item) {
        stckll.insert(item);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String pop() {
        return stckll.delete();
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return stckll.isEmpty();
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    int size() {
        return stckll.size();
    }
}
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    Stack s = new Stack();
    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(String number) {
        LinkedList li = new LinkedList();
        Node no = new Node();
        for (int i = 0; i < number.length(); i++) {
            // no.data = number;
            // no.next = no;
            li.insert(number);
        }
        return li;

    }
    /**
     * { function_description }.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
        String append = "";
        Node n = new Node();
        for (int i = 0; i < list.size(); i++) {
            append = n.data;
        }
        return append;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        Stack lst1 = new Stack();
        Stack lst2 = new Stack();
        for (int i = 0; i < list1.size(); i++) {
            // list1.push(lst1);
        }
        for (int i = 0; i < list2.size(); i++) {
            // lst2.push(list2);
        }
        return null;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor not used.
    }
    public static void main(String[] args) {
        /**
         * main function.
        */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }    
}
