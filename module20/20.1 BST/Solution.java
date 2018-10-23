import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Class for book details.
 */
class BookDetails implements Comparable {
    /**
     * variable declaration.
     */
    private String bookname;
    /**
     * variable declaration.
     */
    private String authorname;
    /**
     * variable declaration.
     */
    private float bookprice;
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      bookname1    The bookname
     * @param      authorname1  The bookauthor
     * @param      bookprice1   The bookprice
     */
    BookDetails(final String bookname1,
                final String authorname1, final float bookprice1) {
        this.bookname = bookname1;
        this.authorname = authorname1;
        this.bookprice = bookprice1;
    }
    /**
     * Gets the name.
     * Time complexity is 1.
     *
     * @return     The name.
     */
    public String getbookName() {
        return this.bookname;
    }
    /**
     * Gets the author.
     * Time complexity is 1.
     *
     * @return     The author.
     */
    public String getAuthorname() {
        return this.authorname;
    }
    /**
     * Gets the price.
     * Time complexity is 1.
     *
     * @return     The price.
     */
    public float getbookPrice() {
        return this.bookprice;
    }
    /**
     * compare to method that returns integer.
     * Time complexity is 1.
     *
     * @param      obj  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object obj) {
        BookDetails t = (BookDetails) obj;
        return this.bookname.compareTo(t.bookname);
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getbookName() + ", "
        + getAuthorname() + ", " + getbookPrice();
    }
}
/**
 * Class for binary search tree.
 */
class BST {
    /**
     * variable declaration.
     */
    private Node root;
    /**
     * Class for node.
     */
    private final class Node {
        /**
         * variable declaration.
         */
        private BookDetails key;
        /**
         * variable declaration.
         */
        private int value;
        /**
         * variable declaration.
         */
        private Node left;
        /**
         * variable declaration.
         */
        private Node right;
        /**
         * variable declaration.
         */
        private int size;
        /**
         * Constructs the object.
         * Time complexity is 1.
         *
         * @param      key2    The key 2
         * @param      value1  The value 1
         * @param      size1   The size 1
         */
        private Node(final BookDetails key2,
            final int value1, final int size1) {
            this.key = key2;
            this.value = value1;
            this.size = size1;
            left = null;
            right = null;
        }
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    BST() {
        root = null;
    }
    /**
     * size.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(root);
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
     * size.
     * Time complexity is 1.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int size(final Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.size;
        }
    }
    /**
     * get method.
     *time complexity is O(logN)
     * @param      key   The key
     *
     * @return  integer.
     */
    public int get(final BookDetails key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else if (cmp == 0) {
                return node.value;
            }
        }
        return -1;
    }
    /**
     * put method to insert the key, value.
     *time complexity is O(N)
     * @param      ky   The key
     * @param      value   The value
     */
    public void put(final BookDetails ky, final int value) {
        root = put(root, ky, value);
    }
    /**
     * overloaded constructor.
     * time complexity is O(N)
     * @param      n   root node.
     * @param      ky   The key
     * @param      value   The value
     *
     * @return root
     */
    private Node put(final Node n, final BookDetails ky, final int value) {
        if (n == null) {
            return new Node(ky, value, 1);
        }
        int cmp = ky.compareTo(n.key);
        if (cmp < 0) {
            n.left = put(n.left, ky, value);
        } else if (cmp > 0) {
            n.right = put(n.right, ky, value);
        } else if (cmp == 0) {
            n.value = value;
        }
        return n;
    }
    /**
     * min element.
     * Time complexity is logN.
     *
     * @return minimum.
     */
    public BookDetails min() {
        return min(root).key;
    }
    /**
     * overloaded constructor.
     * Time complexity is logN.
     *
     * @param      x Node
     *
     * @return minimum.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * maximum element.
     * Time complexity is logN.
     *
     * @return maximum.
     */
    public BookDetails maximum() {
        return maximum(root).key;
    }
    /**
     * overloaded constructor.
     * Time complexity is logN.
     *
     * @param      n Node
     *
     * @return maximum.
     */
    private Node maximum(final Node n) {
        if (n.right == null) {
            return n;
        } else {
            return maximum(n.right);
        }
    }
    /**
     * floor method.
     * Time complexity is logN.
     *
     * @param      key   The key
     *
     * @return  key
     */
    public BookDetails floor(final BookDetails key) {
        Node n = floor(root, key);
        if (n == null) {
            return null;
        } else {
            return n.key;
        }
    }
    /**
     * floor.
     * Time complexity is logN.
     * @param      n     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node n, final BookDetails key) {
        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(n.key);
        if (cmp == 0) {
            return n;
        }
        if (cmp <  0) {
            return floor(n.left, key);
        }
        Node n1 = floor(n.right, key);
        if (n1 != null) {
            return n1;
        } else {
            return n;
        }
    }
    /**
     * ceiling using key.
     * Time complexity is logN.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public BookDetails ceiling(final BookDetails key) {
        Node n = ceiling(root, key);
        if (n == null) {
            return null;
        } else {
            return n.key;
        }
    }
    /**
     * ceiling.
     * Time complexity is logN.
     *
     * @param      n     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node n, final BookDetails key) {
        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(n.key);
        if (cmp == 0) {
            return n;
        }
        if (cmp < 0) {
            Node n1 = ceiling(n.left, key);
            if (n1 != null) {
                return n1;
            } else {
                return n;
            }
        }
        return ceiling(n.right, key);
    }
    /**
     * select using key.
     * Time complexity is logN.
     *
     * @param      k1    The k 1
     *
     * @return     { description_of_the_return_value }
     */
    public BookDetails select(final int k1) {
        Node x = select(root, k1);
        return x.key;
    }


    /**
     * select node and key.
     * Time complexity is logN.
     *
     * @param      x     { parameter_description }
     * @param      k1    The k 1
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k1) {
        if (x == null) {
            return null;
        }
        int t1 = size(x.left);
        if (t1 > k1) {
            return select(x.left,  k1);
        } else if (t1 < k1) {
            return select(x.right, k1 - t1 - 1);
        } else {
            return x;
        }
    }
    /**
     * rank.
     * Time complexity is logN.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final BookDetails k) {
        return rank(k, root);
    }

    /**
     * // Number of keys in the subtree less than key.
     * Time complexity is logN
     *
     * @param      key   The key
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int rank(final BookDetails key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
    /**
     * delete min.
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMin(root);
        // assert check();
    }
    /**
     * delete minimum element.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * deletemax().
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMax(root);
        // assert check();
    }
    /**
     * deletemax.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * delete.
     *
     * @param      key   The key
     */
    public void delete(final BookDetails key) {
        if (key == null) {
            throw new NoSuchElementException("calls delete() with a null key");
        }
        root = delete(root, key);
        // assert check();
    }
    /**
     * delete.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node delete(final Node x, final BookDetails key) {
        Node x1 = x;
        if (x1 == null) {
            return null;
        }
        int cmp = key.compareTo(x1.key);
        if (cmp < 0) {
            x1.left  = delete(x1.left,  key);
        } else if (cmp > 0) {
            x1.right = delete(x1.right, key);
        } else {
            if  (x1.right == null) {
                return x1.left;
            }
            if (x1.left  == null) {
                return x1.right;
            }
            Node t = x1;
            x1 = min(t.right);
            x1.right = deleteMin(t.right);
            x1.left = t.left;
        }
        x1.size = size(x1.left) + size(x1.right) + 1;
        return x1;
    }
}
/**
 * client program.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
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
        BST bst = new BST();
        while (s.hasNext()) {
            String[] token = s.nextLine().split(",");
            switch (token[0]) {
            case "put":
                BookDetails book = new BookDetails(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                bst.put(book, Integer.parseInt(token[2 + 2]));
            break;
            case "max":
                System.out.println(bst.maximum());
            break;
            case "min":
                System.out.println(bst.min());
            break;
            case "get":
                book = new BookDetails(token[1], token[2],
                        Float.parseFloat(token[2 + 1]));
                if (bst.get(book) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(book));
                }
            break;
            case "select":
                System.out.println(bst.select(
                    Integer.parseInt(token[1])));
            break;
            case "floor":
                book = new BookDetails(token[1],
                    token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.floor(book));
            break;
            case "ceiling":
                book = new BookDetails(token[1],
                                        token[2],
                                Float.parseFloat(token[2 + 1]));
                System.out.println(bst.ceiling(book));
            break;
            case "deleteMax":
            bst.deleteMax();
            break;
            case "deleteMin":
            bst.deleteMin();
            break;
            case "delete":
            book = new BookDetails(token[1], token[2],
                        Float.parseFloat(token[2 + 1]));
            bst.delete(book);
            break;
            default:
            break;
            }
        }
    }
}
