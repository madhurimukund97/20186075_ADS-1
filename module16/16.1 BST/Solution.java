import java.util.Scanner;
class BookDetails implements Comparable<BookDetails> {
	private String bookname;
	private String authorname;
	private String price;
	BookDetails(String bookname1, String authorname1, String price1) {
		this.bookname = bookname1;
		this.authorname = authorname1;
		this.price = price1;
	}
	public String getbookname() {
		return this.bookname;
	}
	public String getauthorname() {
		return this.authorname;
	}
	public String getprice() {
		return this.price;
	}
	public int compareTo(BookDetails t) {
 		return this.getbookname().compareTo(t.getbookname());
 	}
}
class BST {
	private Node root;
    private class Node {
        private BookDetails key;
        private String val;
        private Node left, right;
        private int size;

        Node(BookDetails key1, String val1) {
            this.key = key1;
            this.val = val1;
        }
    }
    BST() {
        root = null;
    }
    public void put(BookDetails key, String val) {
			root = put(root, key, val);
		}
	public Node put(Node x, BookDetails key, String val) {
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
	public String get(BookDetails key) {
		Node x = root;
		while (x != null) {
		  	int cmp = key.getbookname().compareTo(x.key.getbookname());
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



public final class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		BST bst = new BST();
		while(s.hasNextLine()) {
			String[] input = s.nextLine().split(",");
			switch(input[0]) {
			 	case "put":
			 		BookDetails book = new BookDetails(input[1], input[2], input[3]);
			 		bst.put(book, input[3]);
			 	break;
			 	case "get":
			 		book = new BookDetails(input[1], input[2], input[3]);
			 		System.out.println(bst.get(book));
			 	break;
			 	default:
			 	break;
			}
		}
	}
}
