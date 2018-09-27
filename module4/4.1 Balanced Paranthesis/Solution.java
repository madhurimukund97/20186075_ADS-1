import java.util.Scanner;
// import java.util.Stack;
import java.util.Arrays;
/**
 * List of .
 */
class Stack {
    /**
     * { Character array }.
     */
    private char[] str;
    /**
     * { Integer size }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Stack() {
        final int ten = 10;
        str = new char[ten];
        size = 0;
    }
    /**
     * { push }.
     *
     * @param      ch    { parameter_description }
     */
    public void push(final char ch) {
        if (isfull()) {
            str = Arrays.copyOf(str, str.length * (2));
        }
        str[size++] = ch;

    }
    /**
     * { pop }.
     *
     * @return     { description_of_the_return_value }
     */
    public char pop() {
        return str[--size];

    }
    /**
     * { isempty }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean isempty() {
        return size == 0;
    }
    /**
     * { peek }.
     *
     * @return     { description_of_the_return_value }
     */
    public char peek() {
        return str[size - 1];
    }
    /**
     * { boolean isfull }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean isfull() {
        return size == str.length;
    }
    /**
     * { balanced method }.
     *
     * @param      brac  The brac
     *
     * @return     { description_of_the_return_value }
     */
    public String balanced(final char[] brac) {
        Stack s = new Stack();


        for (char i : brac) {
            if (i == '{' || i == '[' || i == '(') {
                s.push(i);
            } else {
                if (!s.isempty()) {
                    char top = s.peek();
                    if ((top == '{' && i == '}')
                        || (top == '[' && i == ']')
                        || (top == '(' && i == ')')) {
                        s.pop();
                    } else {
                        return "NO";
                    }
                } else {
                    return "NO";
                }
            }
        }
        if (s.isempty()) {
            return "YES";
        } else {
            return "NO";
        }
        // return s.isempty()? "YES" : "NO";

    }

}

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
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack sc = new Stack();
        int input = scan.nextInt();
        scan.nextLine();
        while (scan.hasNext()) {
            char[] bracket = scan.nextLine().toCharArray();
            System.out.println(sc.balanced(bracket));
        }
    }
}
