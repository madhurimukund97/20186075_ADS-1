import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * constructor.
    */
    AddLargeNumbers() {

    }
    // Stack s = new Stack();
    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        // LinkedList li = new LinkedList();
        // for (int i = 0; i < number.length(); i++) {
        //
        //     li.insert(number);
        // }
        // return li;
        LinkedList<Integer> li = new LinkedList<>();
        for (int i = 1; i < number.length(); i++) {
            li.addLast(Character.getNumericValue(number.charAt(i)));
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
    public static String digitsToNumber(final LinkedList list) {
        String append = "";
        Iterator it = list.listIterator();
        while (it.hasNext()) {
            append += it.next();
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
    public static LinkedList addLargeNumbers(
        final LinkedList list1, final LinkedList list2) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> result = new LinkedList<>();
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        int l1 = s1.length(), l2 = s2.length();
        for (int i = l1 - 1; i >= 0; i--) {
            list1.add(s1.charAt(i) - '0');
        }
        for (int i = l2 - 1; i >= 0; i--) {
            list2.add(s2.charAt(i) - '0');
        }
        int len = l1 > l2 ? l1 : l2;
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int d1 = 0, d2 = 0;        
            // d1 = list1.removeLast(Character.getNumericValue(s1.charAt(i)));
            // d2 = list2.removeLast(Character.getNumericValue(s2.charAt(i)));
            
            int x = d1 + d2 + carry;
            result.add(x % 10);
            carry = x / 10;
        }
        while (carry != 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
        return result;
    }
}