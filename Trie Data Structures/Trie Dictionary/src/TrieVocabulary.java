import java.util.Collection;

public class TrieVocabulary implements Vocabulary{
	private String lowercase = "abcdefghijklmnopqrstuvwxyz";
	private boolean isWord = false;
	// The number of possible children is the number of letters in the alphabet
	private TrieVocabulary[] children = new TrieVocabulary[lowercase.length()];
	// This is the number of actual children
	int numChildren = 0;
	
	public TrieVocabulary(){
		
	}
	
	public TrieVocabulary(Collection<String> words){
		for(String w: words){
			add(w);
		}
	}

	/**
	 * word: abc				--> bc					--> c
	 * first = a				--> b					--> c
	 * index = 0				--> 1					--> 2
	 * child = null --> new child
	 * children[0] = child 		--> children[1] = child --> children[2] = child
	 * numChildren = 1			--> numChildren = 2		-->numChildren = 3
	 * isWord = false			--> false				--> true
	 */
	@Override
	public boolean add(String word) {
		char first = word.charAt(0);
		int index = lowercase.indexOf(first);
		
		if(index < 0){
			System.out.println("This is not a letter");
		}
		
		TrieVocabulary child = children[index];
		if(child == null){
			child = new TrieVocabulary();
			children[index] = child;
			numChildren++;
		}
		
		// If there is not more letter then we set this as word
		if(word.length() == 1){
			if(child.isWord){
				// The word is already in the trie
				return false;
			}
			
			child.isWord = true;
		} else { 
			return child.add(word.substring(1));
		}
		
		
		return false;
	}

	/*
	 * Search for a string prefix in this trie
	 */
	@Override
	public boolean isPrefix(String prefix) {
		TrieVocabulary node = getNode(prefix);
		return node != null && node.numChildren > 0;
	}

	
	@Override
	public boolean contains(String word) {
		TrieVocabulary node = getNode(word);
		return node != null && node.isWord;
	}
	
	/*
	 * word = a b c
	 * 		  ^
	 * node = all words --> a -> b -> c / b -> c / c
	 * index = 0 / 1 / 2
	 * child = a -> b -> c /--> b -> c / c
	 */
	private TrieVocabulary getNode(String word){
		TrieVocabulary node = this;
		for(int i = 0; i<word.length(); i++){
			int index = lowercase.indexOf(word.charAt(i));
			TrieVocabulary child = node.children[index];
			
			if(child == null){
				//There is no such word 
				return null;
			}
			node = child;
		}
		
		return node;
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

}
