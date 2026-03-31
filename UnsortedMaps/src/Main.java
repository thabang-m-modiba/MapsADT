/**
 * @author Thabang Mamoloko
 */

/**
 * The main method class
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnsortedTableMap<Integer, String> map = new UnsortedTableMap<>();
		
		map.put(1, "A");
		map.put(2, "B");
		for(int i = 1; i < map.size() + 1; i++)
		    System.out.print(map.get(i) + ", ");
		System.out.println("End");

	}

}
