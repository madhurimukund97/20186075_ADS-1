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
class InsertionSort {
	private Tournament[] tArray;
	private int size;
	InsertionSort() {
		this.size = 0;
		this.tArray = new Tournament[10];
	}
	public String toString() {
		int res = 0;
        String string = "";
        for (res = 0; res <= size - 1; res++) {
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
	public void insertionsort() {
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (tArray[j].compareTo(tArray[j-1]) == 1) {
					swapping(tArray, j , j-1);
				} else {
					break;
				}
			}
		}
	}

	public int size() {
		return size;
	}
	public void resize() {
		tArray = Arrays.copyOf(tArray, 2*tArray.length);
	}
	public void swapping(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

public final class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		InsertionSort is = new InsertionSort();
		while (s.hasNext()) {
			String[] token = s.nextLine().split(",");
			is.add(new Tournament(token[0], Integer.parseInt(token[1]),
                Integer.parseInt(token[2]), Integer.parseInt(token[3])));
		}
		is.insertionsort();
		System.out.println(is);
	}
}
