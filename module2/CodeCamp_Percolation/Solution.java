import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { var_description }
     */
    private WeightedQuickUnionUF weigh;
    private int num;
    private int size;
    private int begin;
    private int end;
    private int count;
    private boolean[] arr;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
   public Percolation(int num1) {
   // create n-by-n grid, with all sites blocked

    this.num = num1;
    this.size = num1 * num1;
    this.begin = size;
    this.count = 0;
    this.end = size + 1;
    arr = new boolean[size];
    // if (num < 2) {

    // }
    weigh = new WeightedQuickUnionUF(size + 2);
    for (int i = 0; i < num; i++) {
        weigh.union(begin, i);
        weigh.union(end, size - i - 1);
    }
    }
   /**
    * Searches for the first match.
    *
    * @param      n1    The n 1
    * @param      n2    The n 2
    *
    * @return     { description_of_the_return_value }
    */
    private int indexOf(int n1, int n2) {
        return num * (n1 - 1) + n2 - 1;
    }
    /**
     * Opens sites.
     *
     * @param      row   The row
     * @param      col   The col
     */
    private void openSites(int row, int col) {
        if (arr[col] && !weigh.connected(row, col)) {
            weigh.union(row, col);
        }
    }
   /**
    * { function_description }.
    *
    * @param      row   The row
    * @param      col   The col
    */
    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        int ind = indexOf(row, col);
        arr[ind] = true;
        count = count + 1;
        int up = ind - num;
        int down = ind + num;
        if (num == 1) {
            weigh.union(begin, ind);
            weigh.union(end, ind);
        }
        if (up >= 0) {
            openSites(ind, up);
        }
        if (down < size) {
            openSites(ind, down);
        }

        if (col == 1) {
            if (col != num - 1) {
                openSites(ind, ind + 1);
            }
            return;
        }
        if(col == num) {
            openSites(ind, ind - 1);
            return;
        }
        // if (num == 2) {
        //     weigh.union(ind, ind + 1);
        //     weigh.union(ind, );
        //     // return;
        // }
        openSites(ind, ind + 1);
        openSites(ind, ind - 1);
    }
   /**
    * Determines if open.
    *
    * @param      row   The row
    * @param      col   The col
    *
    * @return     True if open, False otherwise.
    */
    public boolean isOpen(int row, int col) {
        // is site (row, col) open?
        return arr[indexOf(row, col)];
    }
   // /**
   //  * Determines if full.
   //  *
   //  * @param      row   The row
   //  * @param      col   The col
   //  *
   //  * @return     True if full, False otherwise.
   //  */
   //  public boolean isFull(int row, int col) {
   //      // is site (row, col) full?
   //      return false;





   //  }
    /**
    * { function_description }.
    *
    * @return     { description_of_the_return_value }
    */
    public int numberOfOpenSites() { 
        // number of open sites

        return count;


    }
   /**
    * { function_description }.
    *
    * @return     { description_of_the_return_value }
    */
    public boolean percolates() {    
    // does the system percolate?
        return weigh.connected(begin, end);
    }
}


// You can implement the above API to solve the problem

/**
 * { solution class }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // constructor not used.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Percolation perobj = new Percolation(n);
        while (s.hasNext()) {
            String tokens[] = s.nextLine().split(" ");
            perobj.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        System.out.println(perobj.percolates() && perobj.numberOfOpenSites() != 0);
    }
}
