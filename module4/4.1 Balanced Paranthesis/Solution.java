import java.util.Scanner;
// import java.util.Stack;
import java.util.Arrays;
/**
 * List of .
 */
class Stack {
    char [] str;
    int size;
    /**
     * Constructs the object.
     */
    public Stack() {
        str = new char[10];
        size = 0;

    }
    
    public void push(final char ch) {
        if (isfull()) {
            str = Arrays.copyOf(str, str.length * (2));
        }
        str[size++] = ch;

    }
    
    public char pop() {
        return str[--size];

    }
    
    public boolean isempty() {
        return size == 0;
    }
    
    public char peek() {
        return str[size - 1];
    }
    
    public boolean isfull() {
        return size == str.length;
    }

    public String balanced(final char[] brac) {
        // Stack s = new Stack();


        for (char i : brac) {
            if (i == '{' || i == '[' || i == '(') {
                push(i);
            } else {
                if (!isempty()) {
                    char last = peek();
                    if ((last == '{' && i == '}')
                        || (last == '[' && i == ']')
                        || (last == '(' && i == ')')) {
                        pop();
                    } else {
                        return"NO";
                    }
                } else {
                    return "NO";
                }
            }
        }
        if (isempty()) {
            return "YES";
        } else {
            return "NO";
        }

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
		// constructor not used.
	}
	/**
	 * { main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
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
