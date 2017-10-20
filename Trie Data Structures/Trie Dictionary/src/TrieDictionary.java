import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrieDictionary {

	public static void main(String[] args) throws Exception{
		// Load the words from the resource file
		InputStream is =  TrieDictionary.class.getResourceAsStream("/words_en.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		ArrayList<String> words = new ArrayList<>(150000);
		
		do {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			if (line.matches("[a-z]+")) {
				words.add(line);
			}
		} while (true);
		reader.close();
		
		System.out.println("Amount of words: " + words.size());
		
		ListVocabulary listVocabulary = new ListVocabulary(words);
		TreeVocabulary treeVocabulary = new TreeVocabulary(words);
		
		// Create a test
		List<String> testSet = new ArrayList<String>();
		for(int i=0; i<10; i++){
			int r = (int)(Math.random() * words.size());
			System.out.println("Random number is : " + r);
			testSet.add(words.get(r));
		}
		
		// Test adding a new word "aaaa"
		listVocabulary.add("aaaa");
		boolean resultPrefix = listVocabulary.isPrefix("aaa");
		
		//Test using prefix in a treeVocabulary
		boolean resultTreePrefix = treeVocabulary.isPrefix("aaa");
		
		System.out.println("Result list: " + resultPrefix + " - Result Tree: " + resultTreePrefix);
		
		System.out.println("");
		
		Iterator<String> i = testSet.iterator();
		while(i.hasNext()){
			System.out.println("Word: " + i.next());
		}
		
		System.out.println("");
		
		int found = 0;
		long start = System.currentTimeMillis();
		for(String word : testSet){
			if(listVocabulary.contains(word)){
				found++;
			}
		}
		
		System.out.println("Completed in "
				+ (System.currentTimeMillis() - start) + " ms. Found "
				+ found);
		
		
		// Test with trie
		TrieVocabulary trie = new TrieVocabulary();
		trie.add("abc");
		trie.add("abca");
		trie.add("abcd");
		
		String prefix = "abc";
		if(trie.isPrefix(prefix)){
			System.out.println(prefix + " is a prefix");
		} else {
			System.out.println(prefix + " is not a prefix");
		}
		
		String word = "abcde";
		if(trie.contains(word)){
			System.out.println(word + " is a word");
		} else {
			System.out.println(word + " is not a word");
		}
		
		
	}
}
