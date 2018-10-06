import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * String type name.
     */
    private String name;
    /**
     * String type date of birth.
     */
    private String dob;
    /**
     * String type Category.
     */
    private String category;
    /**
     * Integer type marks1.
     */
    private int marks1;
    /**
     * Integer type marks2.
     */
    private int marks2;
    /**
     * Integer type marks3.
     */
    private int marks3;
    /**
     * Integer type total.
     */
    private int total;
    /**
     * constructor of type student. 
     */
    private Student[] sArray;
    /**
     * Integer type.
     */
    private int size;
    // /**
    //  * Constructs the object.
    //  *
    //  * @param      name1      The name 1
    //  * @param      dob1       The dob 1
    //  * @param      smarks1    The smarks 1
    //  * @param      smarks2    The smarks 2
    //  * @param      smarks3    The smarks 3
    //  * @param      total1     The total 1
    //  * @param      category1  The category 1
    //  */
    /**
     * constructs an object.
    */
    Student() {
        size = 0;
        final int ten = 10;
        sArray = new Student[ten];
        // final String name1, final String dob1, final int smarks1,
        // final int smarks2, final int smarks3, final int total1,
        // final String category1
        // this.name = name1;
        // this.dob = dob1;
        // this.marks1 = smarks1;
        // this.marks2 = smarks2;
        // this.marks3 = smarks3;
        // this.total = total1;
        // this.category = category1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the dob.
     *
     * @return     The dob.
     */
    public String getDob() {
        return this.dob;
    }
    /**
     * Gets the marks 1.
     *
     * @return     The marks 1.
     */
    public int getMarks1() {
        return this.marks1;
    }
    /**
     * Gets the marks 2.
     *
     * @return     The marks 2.
     */
    public int getMarks2() {
        return this.marks2;
    }
    /**
     * Gets the marks 3.
     *
     * @return     The marks 3.
     */
    public int getMarks3() {
        return this.marks3;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return this.total;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return this.category;
    }
    // /**
    //  * Priority thata means in descending order.
    //  *
    //  * @param      total  The total
    //  */
    // public void priority(int total) {
    //     for (int i = 0; i < )
    // }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String print() {
        int res = 0;
        String string = "";
        for (res = 0; res < size - 1; res++) {
            string += sArray[res].getName() + ", ";
        }
        string += sArray[res].getName();
        return string;
    }
    /**
     * get the priority.
     */
    public void sort() {
        
    }
}
/**
 * Main class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor not used.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Student st = new Student();
        int nq = s.nextInt();
        int nv = s.nextInt();
        int ur = s.nextInt();
        int bc = s.nextInt();
        int sc = s.nextInt();
        int stcategory = s.nextInt();
        while (s.hasNext()) {
            s.nextLine();
        }
        st.print();

    }
}
