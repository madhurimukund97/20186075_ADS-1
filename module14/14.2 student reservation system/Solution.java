import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {
        // default constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int noCategry = Integer.parseInt(scan.nextLine());
        int noOfBC = Integer.parseInt(scan.nextLine());
        int noOfSC = Integer.parseInt(scan.nextLine());
        int noOfST = Integer.parseInt(scan.nextLine());
        Student[] students = new Student[n];
        for (int k = 0; k < n; k++) {
            String[] tokens = scan.nextLine().split(",");
            students[k] = new Student(
                tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[2 + 1]),
                Integer.parseInt(tokens[2 + 2]),
                Integer.parseInt(tokens[2 + 2 + 1]),
                tokens[2 + 2 + 2]);
        }
        Heap.sort(students);
        print(students);

        allotment(students, vacancies, noCategry, noOfBC,
                  noOfSC, noOfST);
    }
    /**
     * used to print.
     * Time complexity is N.
     *
     * @param      students  The students
     */
    public static void print(final Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
    /**
     * Alloting the seats to the students based on merit.
     * @param students  list of students.
     * @param vacancies number of vacancies.
     * @param noCategry Un-reserved category.
     * @param noBC      Number of BC seats.
     * @param noSC      Number of SC seats.
     * @param noST      Number of ST seats.
     * Time complexity is N.
     */
    public static void allotment(final Student[] students,
                                 int vacancies,
                                 int noCategry,
                                 int noBC,
                                 int noSC,
                                 int noST) {
        int i = 0;
        int k = 0;
        int n = students.length;
        Student[] alloted = new Student[vacancies];

        for (i = 0; i < n; i++) {
            if (vacancies == 0) {
                break;
            }

            if (noCategry > 0) {
                noCategry--;
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }

            if (noBC > 0) {
                if (students[i].getRc().equals("BC") &&
                        students[i].getAlloted() != true) {
                    noBC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("SC") &&
                        students[i].getAlloted() != true) {
                    noSC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("ST") &&
                        students[i].getAlloted() != true) {
                    noST--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (vacancies > 0 && students[i].getRc().equals("Open") &&
                    students[i].getAlloted() == false) {
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }
        }

        Heap.sort(alloted);
        print(alloted);
    }
}
/**
 * Class for student.
 * Time complexity is 1.
 */
class Student implements Comparable<Student> {
    /**
     * { var_description }
     */
    private String studentName;
    /**
     * { var_description }
     */
    private Date db;
    /**
     * { var_description }
     */
    private int m1;
    /**
     * { var_description }
     */
    private int m2;
    /**
     * { var_description }
     */
    private int m3;
    /**
     * { var_description }
     */
    private int tm;
    /**
     * { var_description }
     */
    private String rc;
    /**
     * { var_description }
     */
    private boolean alloted;
    /**
     * returns true, if the student is already alloted,
     * otherwise false.
     *
     * @return true if alloted, otherwise false.
     * Time complexity is 1.
     */
    public boolean getAlloted() {
        return alloted;
    }
    /**
     * Changes the alloted status to true once the allotment is done.
     *
     * @param      allot  should be either true or false.
     * Time complexity is 1.
     */
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }
    /**
     * Gets the data of birth.
     * @return date of birth.
     * Time complexity is 1.
     */
    public Date getDb() {
        return db;
    }
    /**
     * sets the student's date of birth.
     *
     * @param      b     [description]
     * Time complexity is 1.
     */
    public void setDb(final Date b) {
        this.db = b;
    }
    /**
     * gets the date of birth.
     *
     * @return     the student's date of birth.
     * Time complexity is 1.
     */
    public String getRc() {
        return rc;
    }
    /**
     * Sets the student's reservation category.
     *
     * @param      r     { parameter_description }
     * Time complexity is 1.
     */
    public void setRc(final String r) {
        this.rc = r;
    }
    /**
     * gets the total marks.
     * @return returns the total marks of the student.
     * Time complexity is 1.
     */
    public int getTm() {
        return tm;
    }
    /**
     * sets the student's total marks.
     *
     * @param      m     { parameter_description }
     * Time complexity is 1.
     */
    public void setTm(final int m) {
        this.tm = m;
    }
    /**
     * Constructs the object based on the parameters.
     *
     * @param      studentNme  Student Name
     * @param      dateOfBirth  Date of Birth
     * @param      m11           Marks in first subject.
     * @param      m22           Marks in second subject.
     * @param      m33           Marks in third subject.
     * @param      tm1           Total Marks.
     * @param      rc1          Reservation Category.
     * Time complexity is 1.
     */
    Student(final String studentNme, final String dateOfBirth,
                   final int m11, final int m22, final int m33, final int tm1,
                   final String rc1) {
        this.studentName = studentNme;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.m1 = m11;
        this.m2 = m22;
        this.m3 = m33;
        this.tm = tm1;
        this.rc = rc1;
        this.alloted = false;
    }
    /**
     * Gets the marks in subject 3.
     *
     * @return     m3 Marks in subject 3.
     * Time complexity is 1.
     */
    public int getM3() {
        return m3;
    }
    /**
     * Sets the m3 to the 3rd subject.
     * Time complexity is 1.
     *
     * @param      m     { parameter_description }
     */
    public void setM3(final int m) {
        this.m3 = m;
    }
    /**
     * Gets the marks in subject 2.
     * Time complexity is 1.
     *
     * @return     marks in subject 2.
     */
    public int getM2() {
        return m2;
    }
    /**
     * Sets marks in subject 2.
     * Time complexity is 1.
     *
     * @param      m     { parameter_description }
     */
    public void setM2(final int m) {
        this.m2 = m;
    }
    /**
     * Gets the marks in subject 1.
     * @return marks in subject 1.
     * Time complexity is 1.
     */
    public int getM1() {
        return m1;
    }
    /**
     * Sets the marks to subject 1.
     *
     * @param      m     { parameter_description }
     * Time complexity is 1.
     */
    public void setM1(final int m) {
        this.m1 = m;
    }
    /**
     * Gets the student name.
     * @return the student's name.
     * Time complexity is 1.
     */
    public String getStudentName() {
        return studentName;
    }
    /**
     * Sets the student name.
     * Time complexity is 1.
     *
     * @param      student  The student
     */
    public void setStudentName(final String student) {
        this.studentName = student;
    }
    /**
     * Compares two objects of types students.
     * @param  that second Student.
     * @return integer based on the requirements.
     * Time complexity is 1.
     */
    public int compareTo(final Student that) {
        if (this.getTm() > that.getTm()) {
            return -1;
        }
        if (this.getTm() < that.getTm()) {
            return 1;
        }
        if (this.getM3() > that.getM3()) {
            return -1;
        }
        if (this.getM3() < that.getM3()) {
            return 1;
        }
        if (this.getM2() > that.getM2()) {
            return -1;
        }
        if (this.getM2() < that.getM2()) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) < 0) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) > 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Gets the String version of the Students.
     * @return String version of object.
     * Time complexity is 1.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTm() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}
/**
 * Class for heap.
 */
final class Heap {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Heap() {
        //Unused Constructor.
    }
    /**
     * Sink method.
     * Time complexity is logN.
     *
     * @param      arr    { parameter_description }
     * @param      k     { parameter_description }
     * @param      n     { parameter_description }
     */
    private static void sink(final Comparable[] arr, int k, final int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k, j)) {
                break;
            }
            exch(arr, k, j);
            k = j;
        }
    }
    /**
     * less method.
     * Time complexity is 1.
     *
     * @param      arr    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private static boolean less(final Comparable[] arr,
        final int i, final int j) {
        return arr[i - 1].compareTo(arr[j - 1]) < 0;
    }
    /**
     * used to exchange.
     * Time complexity is 1.
     *
     * @param      arr    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private static void exch(final Comparable[] arr, final int i, final int j) {
        Comparable swap = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = swap;
    }
    /**
     * Sort method.
     * Time complexity is logN.
     *
     * @param      arr    { parameter_description }
     */
    public static void sort(final Comparable[] arr) {
        int n = arr.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(arr, k, n);
        }
        while (n > 1) {
            exch(arr, 1, n--);
            sink(arr, 1, n);
        }
    }
}
