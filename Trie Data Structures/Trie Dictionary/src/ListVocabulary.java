import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * This class store words in a sorted list. Binary search is used to find the words
 * and the prefixes
 */
public class ListVocabulary implements Vocabulary{
	
	private List<String> words;
	
	
	public ListVocabulary(){
		// It's important to use a List that implements RandomAccess
		// so that Collections.binarySearch() can work in O(log(n)) time
		words = new ArrayList<String>();
	}
	
	public ListVocabulary(Collection<String> words){
		this();
		this.words.addAll(words);
		Collections.sort(this.words);
	}

	@Override
	public boolean add(String word) {
		int pos = Collections.binarySearch(words, word);
		// pos > 0 means the word is already in the list. Insert only
		// if it's not yet return (-insertion point) - 1)
		System.out.println( word + " --> position : " + -(pos+1));
		
		if(pos < 0){
			System.out.println("add " + word + " in position " + -(pos+1));
			words.add(-(pos+1), word);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isPrefix(String prefix) {
		int pos = Collections.binarySearch(words, prefix);
		
		if(pos >= 0){
			// The prefix is a word. Check the following word, because we are
			// looking for words that are longer than the prefix
			if(pos + 1 < words.size()){
				String nextWord = words.get(pos + 1);
				return nextWord.startsWith(prefix);
			}
			return false;
		}
		
		pos = -(pos+1);
		// The prefix is not a word. Check where it would be inserted and get the next word.
		// If it starts with prefix, return true
		if(pos == words.size()){
			return false;
		}
		
		String nextWord = words.get(pos);
		
		return nextWord.startsWith(prefix);
	}

	@Override
	public boolean contains(String word) {
		int pos = Collections.binarySearch(words, word);
		
		return pos >= 0;
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

}
