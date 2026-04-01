/**
 * @author Textbook: Data Structures and Algorithms in Java 6th Edition 2014
 */
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * Class contains the main method
 */
public class WordCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChainHashMap<String, Integer> freq = new ChainHashMap<>();
        
        // Scan input for words, using all nonletters as delimiters
        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
        // System.out.print("Enter: ");
        while(doc.hasNext()) {
        	String word = doc.next().toLowerCase();
        	Integer count = freq.get(word);
        	if(count == null) {
        		count = 0;
        	}
        	freq.put(word, 1 + count);
        }
        doc.close();
        int maxCount = 0;
        String maxWord = "no word";
        for(Entry<String, Integer> ent : freq.entrySet()) {
        	if(ent.getValue() > maxCount) {
        		maxWord = ent.getKey();
        		maxCount = ent.getValue();
        	}
        	System.out.print("The most frequent word is " + maxWord);
        	System.out.println(", with " + maxCount + " occurances.");
        }
        
        /**
         * Fix code bugs
         */

	}

}
