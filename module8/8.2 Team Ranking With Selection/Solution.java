import java.util.Scanner;
import java.util.Arrays;
class Tournament implements Comparable {
	private String tName;
    private int winner;
    private int losser;
    private int draw;
    Tournament() {

    }
    Tournament(final String n, final int w, final int l, final int d) {
        this.tName = n;
        this.winner = w;
        this.losser = l;
        this.draw = d;
    }
    public int getLosser() {
        return this.losser;
    }
    public int getDraw() {
        return this.draw;
    }
    public int compareTo(Object ob) {
    	//System.out.println("i am compareto");
    	Tournament t = (Tournament) ob;
    	if (this.getWinner() > t.getWinner()) {
    		return 1;
    	} else if (this.getWinner() < t.getWinner()) {
    		return -1;
    	}
	    if (this.getLosser() < t.getLosser()) {
	    	return 1;
	    } else if (this.getLosser() > t.getLosser()) {
	    	return -1;
	    }
		if (this.getDraw() > t.getDraw()) {
		   	return 1;
		} else if (this.getDraw() < t.getDraw()) {
		   	return -1;
		}
	    return 0;
    }
    public String getname() {
        return this.tName;
    }
    public int getWinner() {
        return this.winner;
    }

}
class SelectionSort {
	private Tournament[] tArray;
	private int size;
	SelectionSort() {
		this.size = 0;
		this.tArray = new Tournament[10];
	}
	public String toString() {
		int res = 0;
        String string = "";
        for (res = 0; res < size - 1; res++) {
            string += tArray[res].getname() + ",";
        }
        string += tArray[res].getname();
        return string;
	}
	public void add(Tournament g) {
		if(size == tArray.length) {
			resize();
		}
		tArray[size++] = g;
	}
	public void selectionsort() {
		// int N = a.length;
		for (int i = 0; i < size; i++) {
			int min = i; 
			int j;     
			for (j = i+1; j < size; j++) {
				if (tArray[j].compareTo(tArray[j-1]) == 1) {
					min = j; 
				}
			}  
			swapping(tArray, i, j);
		}
	}
	/**
	 * used to return the size.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return size;
	}
	/**
	 * used to resize the lenth of an array.
	 * 
	 */
	public void resize() {
		tArray = Arrays.copyOf(tArray, 2*tArray.length);
	}
	/**
	 * Used to swap the position of the variables when it is small.
	 * The time complexity for resize() is 1.
	 *
	 * @param      arr   The arr
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	public void swapping(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
/**
 * 
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		// constructor not used.
	}
	/**
	 * 
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		final int three = 3;
		Scanner s = new Scanner(System.in);
		SelectionSort ss = new SelectionSort();
		while (s.hasNext()) {
			String[] token = s.nextLine().split(",");
			ss.add(new Tournament(token[0], Integer.parseInt(token[1]),
                Integer.parseInt(token[2]), Integer.parseInt(token[three])));
		}
		ss.selectionsort();
		System.out.println(ss);
	}
}
