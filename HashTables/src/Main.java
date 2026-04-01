/**
 * @author Thabang Mamoloko
 */

/**
 * Main method Class
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("<--- Separate Chain --->");
		
		ChainHashMap<String, Integer> map = new ChainHashMap<>();
		map.put("Key1", 21);
		map.put("Key2", 15);
		map.put("Key3", 87);
		// map.bucketPut(map, "Key4", 98);
		System.out.println(map.get("Key4"));
		System.out.println();
		
		/**
		 * Fix the main method
		 */

	}

}
