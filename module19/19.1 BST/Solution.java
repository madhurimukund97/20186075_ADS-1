import java.util.Scanner;
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
     *
     * @param      bookname    The bookname
     * @param      bookauthor  The bookauthor
     * @param      bookprice   The bookprice
     */
    BookDetails(final String bookname1,
                final String authorname1, final float bookprice1) {
        this.bookname = bookname1;
        this.authorname = authorname1;
        this.bookprice = bookprice1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getbookName() {
        return this.bookname;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthorname() {
        return this.authorname;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getbookPrice() {
        return this.bookprice;
    }
    /**
     * compare to method that returns integer.
     *
     * @param      obj  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object obj) {
        BookDetails t = (BookDetails) obj;
        return this.bookname.compareTo(t.bookname);
    }
    public String toString() {
        return getbookName()+", "+getAuthorname()+", "+getbookPrice();
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
         *
         * @param      key2   The key
         * @param      value1  The value
         */
        private Node(final BookDetails key2, final int value1, final int size1) {
            this.key = key2;
            this.value = value1;
            this.size = size1;
            left = null;
            right = null;
        }
    }
    /**
     * Constructs the object.
     */
    BST() {
        root = null;
    }
    public int size() {
        return size(root);
    }

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
     * @param      ky   The key
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
     * @param      key   The key
     * @param      val   The value
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
     *
     * @return minimum.
     */
    public BookDetails min() {
        return min(root).key;
    }
    /**
     * overloaded constructor.
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
     *
     * @return maximum.
     */
    public BookDetails maximum() {
        return maximum(root).key;
    }
    /**
     * overloaded constructor.
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
     *
     * @param      ky   The key
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
     *
     *
     * @param      x     { parameter_description }
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
    public BookDetails ceiling(final BookDetails key) {
        Node n = ceiling(root, key);
        if (n == null) {
            return null;
        } else {
            return n.key;
        }
    }

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
    public BookDetails select(final int k1) {
        Node x = select(root, k1);
        return x.key;
    }
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
    public int rank(final BookDetails k) {
        return rank(k, root);
    }

    // Number of keys in the subtree less than key.
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
}
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
            default:
            break;
            }
        }
    }
}