import java.util.ArrayList;

/**
 * 1. Anagram: To be an anagram the arrangement of letters must make a word - that is, 
 * 		an anagram of a word must have a meaning.
 * 
 * 2. Permutation: a permutation of a word can be any random assortment of characters, 
 * 		not necessarily having a meaning in the original language.
 *
 */
public class PermutateArrayWords {

	public static boolean permutations(String s1, String s2) {
		if(s1.length() != s2.length()){
			return false;
		}
		
		int[] letters = new int[26];
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		for(int i = 0; i < s1.length(); i++){
			letters[i]++;
		}
		
		for(int j = 0; j < s2.length(); j++){
			letters[j]--;
		}
		
		for(int letter: letters){
			if(letter != 0){
				return false;
			}
		}
		
		return true;
		
	}
	
	// TEST
	// In this case I will permutate all the words in the string
	// prefix = ""  -  sufix = {"cat", "dog", "tac", "god", "act"}  - result
	// prefix = cat -  sufix = {"dog", "tac", "god", "act"}  - result
	// prefix = cat dog -  sufix = {"tac", "god", "act"}  - result
	//
	// prefix = cat dog tac god act-  sufix = {}  - ArrayList<String> result = ["cat dog tac god act-  sufix", ]
	public static void printPermutations(String[] words) {
		ArrayList<String> results = new ArrayList<>();
		
		permutation("", words, results);
		
		for(String s: results) {
			System.out.println(s);
		}
	}
	
	public static void permutation(String prefix, String[] suffix, ArrayList<String> results){
		if(suffix.length == 0){
			results.add(prefix);
		}
		
		for(int i = 0; i < suffix.length; i++) {
			String[] newSuffix = new String[suffix.length - 1];
			System.arraycopy(suffix, 0, newSuffix, 0, i);
			System.arraycopy(suffix, i+1, newSuffix, i, newSuffix.length-i);
			
			permutation(prefix + " " + suffix[i], newSuffix, results);
		}
	}
	
	public static void main(String[] args) {
		// 1. Check if 2 strings are anagram
		System.out.println(permutations("adasfdg", "dasfgas"));
		
		// 2. Given a sequence of words, print all anagrams
		String[] words = {"cat", "dog", "tac", "god", "act"};
		printPermutations(words);
		System.out.println();
		
		String[] words2 = {"a", "b", "c", "d"};
		printPermutations(words2);
	}
}
