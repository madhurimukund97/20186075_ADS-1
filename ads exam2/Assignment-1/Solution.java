import java.util.Scanner;

class Student {
	private String name;
	private String dob;
	private String category;
	private int marks1;
	private int marks2;
	private int marks3;
	private int total;
	Student(String name1, String dob1, int smarks1, int smarks2, int smarks3, int total1, String category1) {
		this.name = name1;
		this.dob = dob1;
		this.marks1 = smarks1;
		this.marks2 = smarks2;
		this.marks3 = smarks3;
		this.total = total1;
		this.category = category1;
	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return this.name;
	}
	public String getDob() {
		return this.dob;
	}
	public int getMarks1() {
		return this.marks1;
	}
	public int getMarks2() {
		return this.marks2;
	}
	public int getMarks3() {
		return this.marks3;
	}
	public int getTotal() {
		return this.total;
	}
	public String getCategory() {
		return this.category;
	}
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