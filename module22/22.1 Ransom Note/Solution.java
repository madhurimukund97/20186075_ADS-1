import java.util.Scanner;
/**
 * client program.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor not used.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> obj
        = new SeparateChainingHashST<String, Integer>();
        String[] length = s.nextLine().split(" ");
        String[] str = s.nextLine().split(" ");
        for (int i = 1; i < str.length + 1; i++) {
            if (obj.contains(str[i])) {
                obj.put(str[i], obj.get(str[i]));
            } else {
                obj.put(str[i], 1);
            }
        }
        String[] str1 = s.nextLine().split(" ");
        for (int i = 0; i < str1.length; i++) {
            if (obj.contains(str1[i])) {
                if (obj.get(str1[i]) == 0) {
                    System.out.println("No");
                    return;
                } else {
                    obj.put(str1[i], obj.get(str1[i]) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
