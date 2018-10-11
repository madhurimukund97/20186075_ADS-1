import java.util.Scanner;
/**
 * Class for book details.
 */
class BookDetails implements Comparable<BookDetails> {
	/**
	 * String bookname.
	 */
	private String bookname;
	/**
	 * String author name.
	 */
	private String authorname;
	/**
	 * String price.
	 */
	private String price;
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 *
	 * @param      bookname1    The bookname 1
	 * @param      authorname1  The authorname 1
	 * @param      price1       The price 1
	 */
	BookDetails(final String bookname1,
		final String authorname1, final String price1) {
		this.bookname = bookname1;
		this.authorname = authorname1;
		this.price = price1;
	}
	/**
	 * getbookname.
	 * Time complexity is 1.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getbookname() {
		return this.bookname;
	}
	/**
	 * get author name.
	 * Time complexity is 1.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getauthorname() {
		return this.authorname;
	}
	/**
	 * get price.
	 * Time complexity is 1.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getprice() {
		return this.price;
	}
	/**
	 * compareTo.
	 * Time complexity is 1.
	 *
	 * @param      t     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(final BookDetails t) {
 		return this.getbookname().compareTo(t.getbookname());
 	}
}
/**
 * Class for bst.
 */
class BST {
	/**
	 * Node root.
	 */
	private Node root;
	/**
	 * Class for node.
	 */
    private class Node {
    	/**
    	 * Bookdetails.
    	 */
        private BookDetails key;
        /**
         * { var_description }.
         */
        private String val;
        /**
         * { item_description }.
         */
        private Node left, right;
        /**
         * { var_description }.
         */
        private int size;
        /**
         * Constructs the object.
         * Time complexity is 1.
         *
         * @param      key1  The key 1
         * @param      val1  The value 1
         */
        Node(final BookDetails key1, final String val1) {
            this.key = key1;
            this.val = val1;
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
     * put.
     * Time complexity is 1.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final BookDetails key, final String val) {
			root = put(root, key, val);
		}
	/**
	 * put.
	 * Time complexity is 1.
	 *
	 * @param      x     { parameter_description }
	 * @param      key   The key
	 * @param      val   The value
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Node put(final Node x, final BookDetails key, final String val) {
 		if (x == null) {
 			return new Node(key, val);
 		}
 		int cmp = key.getbookname().compareTo(x.key.getbookname());
 		if (cmp < 0) {
 			x.left = put(x.left, key, val);
 		} else if (cmp > 0) {
 			x.right = put(x.right, key, val);
 		} else if (cmp == 0) {
 			x.val = val;
 		}
 		return x;
		}
	/**
	 * get method.
	 * Time complexity is N.
	 *
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String get(final BookDetails key) {
		Node x = root;
		while (x != null) {
		  	int cmp = key.getbookname().compareTo(
		  		x.key.getbookname());
		 	if (cmp < 0) {
		 		x = x.left;
		 	} else if (cmp > 0) {
		 		x = x.right;
		 	} else if (cmp == 0) {
		 		return x.val;
		 	}
		 	}
		 	return null;
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
		// constructor not used.
	}
	/**
	 * Client program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		final int three = 3;
		final int four = 4;
		Scanner s = new Scanner(System.in);
		BST bst = new BST();
		while (s.hasNextLine()) {
			String[] input = s.nextLine().split(",");
			switch (input[0]) {
			 	case "put":
			 		BookDetails book = new BookDetails(
			 			input[1], input[2],
			 			input[three]);
			 		bst.put(book, input[four]);
			 	break;
			 	case "get":
			 		book = new BookDetails(
			 			input[1], input[2],
			 			input[three]);
			 		System.out.println(bst.get(book));
			 	break;
			 	default:
			 	break;
			}
		}
	}
}
