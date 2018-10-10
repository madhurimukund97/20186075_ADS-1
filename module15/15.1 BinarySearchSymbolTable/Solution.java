import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Class for binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * INIT_capacity.
     */
    private static final int INIT_CAPACITY = 2;
    /**
     * Key array.
     */
    private Key[] keys;
    /**
     * value array.
     */
    private Value[] vals;
    /**
     * Integer n = 0.
     */
    private int n = 0;
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      capacity  The capacity
     */
    BinarySearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    BinarySearchST() {
        this(INIT_CAPACITY);
    }
    /**
     * size.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * resize method.
     * Time complexity is N.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
    /**
     * Determines if empty.
     * Time complexity is 1.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * contains.
     * Time complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }
    /**
     * get.
     * Time complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }
    /**
     * rank.
     * Time complexity is N.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                 hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * put.
     * Time complexity is 1.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val)  {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;

        assert check();
    }
    /**
     * delete.
     * Complexity is N.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n - 1; j++)  {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;
        final int four = 4;
        if (n > 0 && n == keys.length / four) {
            resize(keys.length / 2);
        }
        assert check();
    }
    /**
     * delete min.
     * Time complexity is 1.
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }
    /**
     * delete max.
     * Time complexity is 1.
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Symbol table underflow error");
        }
        delete(max());
    }
   /**
     * Returns the smallest key in this symbol table.
     * Time complexity is 1.
     *
     * @return the smallest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called min() with empty symbol table");
        }
        return keys[0];
    }

    /**
     * Returns the largest key in this symbol table.
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called max() with empty symbol table");
        }
        return keys[n - 1];
    }

    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    /**
     * floor.
     * Time complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * ceiling method.
     * Time complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == n) {
            return null;
        } else {
            return keys[i];
        }
    }

    /**
     * Returns the number of keys in this symbol table in the specified range.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return the number of keys in this symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
    /**
     * check method.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {
        return isSorted() && rankCheck();
    }
    /**
     * Determines if sorted.
     * Time complexity is N.
     *
     * @return     True if sorted, False otherwise.
     */
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * rank check.
     * Time complexity is N.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is N.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size() - 1; i++) {
            s += keys[i] + " " + vals[i] + "\n";
        }
        s += keys[i] + " " + vals[i];
        return s;
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        BinarySearchST<String, Integer> b
            = new BinarySearchST<String, Integer>();
        String[] token = s.nextLine().split(" ");
        for (int i = 0; i < token.length; i++) {
            b.put(token[i], i);
        }
        while (s.hasNextLine()) {
            String[] token1 = s.nextLine().split(" ");
            switch (token1[0]) {
                case "floor":
                    System.out.println(b.floor(token1[1]));
                    break;
                case "rank":
                    System.out.println(b.rank(token1[1]));
                    break;
                case "max":
                    System.out.println(b.max());
                    break;
                case "contains":
                    System.out.println(b.contains(token1[1]));
                    break;
                case "deleteMin":
                    b.deleteMin();
                    break;
                case "keys":
                    System.out.println(b);
                    break;
                case "get":
                    System.out.println(b.get(token1[1]));
                    break;
                default:
                    break;
            }
        }
    }
}
