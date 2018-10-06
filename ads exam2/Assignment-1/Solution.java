import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
	/**
	 * { var_description }
	 */
	private String name;
	/**
	 * { var_description }
	 */
	private String dob;
	/**
	 * { var_description }
	 */
	private String category;
	/**
	 * { var_description }
	 */
	private int marks1;
	/**
	 * { var_description }
	 */
	private int marks2;
	/**
	 * { var_description }
	 */
	private int marks3;
	/**
	 * { var_description }
	 */
	private int total;
	/**
	 * Constructs the object.
	 *
	 * @param      name1      The name 1
	 * @param      dob1       The dob 1
	 * @param      smarks1    The smarks 1
	 * @param      smarks2    The smarks 2
	 * @param      smarks3    The smarks 3
	 * @param      total1     The total 1
	 * @param      category1  The category 1
	 */
	Student(final String name1, final String dob1, final int smarks1,
		final int smarks2, final int smarks3, final int total1,
		final String category1) {
		this.name = name1;
		this.dob = dob1;
		this.marks1 = smarks1;
		this.marks2 = smarks2;
		this.marks3 = smarks3;
		this.total = total1;
		this.category = category1;
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
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		System.out.println(this.name + ", " + this.total + ", " + this.category);
		System.out.println("\n");
		return "l";
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
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// Student st = new Student(nme, d, m1, m2, m3, t, c);
		int nq = s.nextInt();
		int nv = s.nextInt();
		int ur = s.nextInt();
		int bc = s.nextInt();
		int sc = s.nextInt();
		int st = s.nextInt();
		while (s.hasNext()) {
			s.nextLine();

		}

	}
}
