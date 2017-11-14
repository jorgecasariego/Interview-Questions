import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem: Given a sequence of words, print all anagrams together
 * 
 * Explanation
 * ************ 
 * Given an array of words, print all anagrams together. 
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, 
 * then output may be “cat tac act dog god”.
 * 
 * TRIE DATA STRUCTURE
 * 
 * Steps:
 * 	1. Create an empty Trie
 *  2. One by one take all words of input sequence. Do following for each word
 *  	2.1) Copy the word to a buffer
 *  	2.2) Sort the buffer
 *  	2.3) Insert the sorted buffer and index of this word to Trie.
 *   3. Traver trie
 * 
 * The complexity to make a trie structure is O(n*m).
 * 
 * @author jorgecasariego
 *
 */
public class PrintAnagramsTogether {
	static final int NO_OF_CHARS = 26;
	
	// Class to represent a trie
	static class TrieNode {
		boolean isEnd;
		TrieNode[] child = new TrieNode[NO_OF_CHARS];
		
		LinkedList<Integer> head;	// index list
		
		TrieNode() {
			isEnd = false;
			head = new LinkedList<>();
			for(int i = 0; i < NO_OF_CHARS; i++){
				child[i] = null;
			}
		}
	}
	
	// This is a utility function to insert a word to a Trie
	public static TrieNode insert(TrieNode root, String word, int index, int i) {
		// Base case
		if(root == null) {
			root = new TrieNode();
		}
		
		// TEST: act
		// 		   ^ 
		if(i < word.length() - 1) {
			int index1 = word.charAt(i) - 'a';
			root.child[index1] = insert(root.child[index1], word, index, i + 1);
		} else { // IF is the end of the word
			if(root.isEnd == true) {
				root.head.add(index);
			} else {
				root.isEnd = true;
				root.head.add(index);
			}
		}
		
		return root;
	}
	
	public static void printAnagramsUtils(TrieNode root, String[] words) {
		if(root == null){
			return;
		}
		
		if(root.isEnd){
			for(Integer index: root.head) {
				System.out.println(words[index]);
			}
		}
		
		for(int i = 0; i < NO_OF_CHARS; i++){
			printAnagramsUtils(root.child[i], words);
		}
	}
	
	
	public static void printAnagramsTogether(String[] words, int size) {
		// Create an emtpy trie
		TrieNode root = null;
		
		//Iterate throught all input wors
		for(int i = 0; i < size; i++) {
			
			// Create a buffer for this word and copy the word to a buffer
			char[] buffer = words[i].toCharArray();
			
			//sort the buffer
			// TEST: before sorted: "cat", "dog", "tac", "god","act", "gdo"
			Arrays.sort(buffer);

			// TEST 2: If we don't sort buffer before insert this will be the result:
			// act cat dog gdo god tac
			
			// TEST 3: This is the result sorting buffer before insert
			// cat tac act dog god gdo
			
			// Explanation
			// TEST: after sorted: act(0), dgo(1), act(2), dgo(3), act()4, dgo(5)
			// Alpahabetic order of this words by index: 0, 2, 4, 1, 3, 5 = cat tac act dog god gdo

			// Insert the sorted buffer and its original index to Trie
			root = insert(root, new String(buffer), i, 0);
		}
		
		printAnagramsUtils(root, words);
	}
	
	// Driver program to test above functions
    public static void main(String args[])
    {
        String wordArr[] = {"cat", "dog", "tac", "god","act", "gdo"};
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
    }

}
