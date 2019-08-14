import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list 
 * of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of punctuation.  
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * 
 * @author jorgecasariego
 *
 */
public class Main {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = new String[1];
		banned[0] = "hit";
		
		String result = mostCommonWord(paragraph, banned);
		
		System.out.println("Resultado: " + result);
		
		
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> bannedWords = new HashSet<>();
		for(String b: banned) {
			bannedWords.add(b);
		}
		
		HashMap<String, Integer> counter = new HashMap<>();
		for(String word: paragraph.replaceAll("[^a-zA-z]", " ").toLowerCase().split(" ")) {
			if(!bannedWords.contains(word)) {
				counter.put(word, counter.getOrDefault(word, 0) + 1);
			}
		}
		
		String result = "";
		for(String word: counter.keySet()) {
			if(word.equals("") || counter.get(word) > counter.get(result)) {
				result = word;
			}
		}
		
		return result;
		
	}
}
