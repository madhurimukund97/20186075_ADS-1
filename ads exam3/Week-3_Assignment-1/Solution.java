import java.util.Scanner;
/**
 * Class for stock data.
 */
class StockData {
	/**
	 * String type.
	 */
	private String name;
	/**
	 * Double type.
	 */
	private double percentchange;
	/**
	 * Constructs the object.
	 * Time compleixty is 1.
	 *
	 * @param      name1    The name 1
	 * @param      pchange  The pchange
	 */
	StockData(String name1, Double pchange) {
		this.name = name1;
		this.percentchange = pchange;
	}
	/**
	 * getname.
	 * Time compleixty is 1.
	 * @return     { description_of_the_return_value }
	 */
	public String getname() {
		return this.name;
	}
	/**
	 * getpercent.
	 * Time compleixty is 1.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Double getpercent() {
		return this.percentchange;
	}
}
/**
 * Class for query data.
 */
class QueryData {
	/**
	 * Constructs the object.
	 * Time compleixty is 1.
	 */
	QueryData() {
		// constructor not used.
	}
	MinPQ<StockData> stock = new MinPQ<StockData>();
	// StockData stock = new StockData<String, Double>`(String name, Double per);
	/**
	 * getmethod.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int get(String name) {
		int distinct = 0, words = 0;
		String str = "";
		String key = "";
		int minlen = 0;
        // int minlen = Integer.parseInt();
        St<String, Integer> st = new St<String, Integer>();
        while (str.isEmpty()) {
            // String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }
        String max = "";
        st.put(max, 0);
        // for (String word : ) {
        //     if (st.get(word) > st.get(max))
        //         max = word;
        // }
        System.out.println(max + " " + st.get(max));
        return minlen;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
	public String intersection(String name) {
		String str = "";
		// if (getname() > getmax())
		// return stock.getname();
		return str;
	}
}
/**
 * Solution class.
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
		Scanner s = new Scanner(System.in);
		// StockData sd = new StockData();
		MinPQ<StockData> min = new MinPQ<StockData>();
		MaxPQ<StockData> max = new MaxPQ<StockData>();
		int inputlines = s.nextInt();
		s.nextLine();
		// String[] tokens;
		String[] tokens1;
		for (int i = 0; i < 6 * inputlines; i++) {
			// tokens = s.nextLine().split(",");
			for (int k = 0; k < inputlines - 1; k++) {
				String[] tok = s.nextLine().split(",");
				max.insert(new StockData(tok[0], Double.parseDouble(tok[1])));
				System.out.println();
				min.insert(new StockData(tok[0], Double.parseDouble(tok[1])));	
			}
			System.out.println();
		}
		int numofqueries = s.nextInt();
		s.nextLine();
		QueryData qd = new QueryData();
		for (int j = 0; j < numofqueries; j++) {
			tokens1 = s.nextLine().split(",");
			switch (tokens1[0]) {
				case "get":
				qd.get(tokens1[1]);
				break;
				case "intersection":
				qd.intersection(tokens1[1]);
				break;
				default:
				break;
			}
		}
	}
}


