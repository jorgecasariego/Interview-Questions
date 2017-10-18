import java.util.ArrayList;
import java.util.Iterator;

/*
 * permutation("abc")
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * 
 * prefix = ""
 * suffix = "abc"
 * permutation("a", "bc")
 * permutation("b", "ac")
 * permutation("c", "ab")
 * 
 */
public class PermutationArrayList {

	public static ArrayList<String> permutations(String s){
		ArrayList<String> results = new ArrayList<String>();
		permutations("", s, results);
		
		return results;
	}
	
	/*
	 * Test: 
	 * 	permutation("", "abc", [])
	 *  i: 0 - prefix:  - suffix: abc
	 *  	i: 0 - prefix: a - suffix: bc
	 *  		i: 0 - prefix: ab - suffix: c
	 *  			result = ["abc"]
	 *  	
	 *  	i: 1 - prefix: a - suffix: bc 
	 * 			i: 0 - prefix: ac - suffix: b
	 * 				result = ["abc", "acb"]
	 * 
	 *  i: 1 - prefix:  - suffix: abc
	 * 		i: 0 - prefix: b - suffix: ac
	 *  		
	 */
	public static void permutations(String prefix, String suffix, ArrayList<String> results){
		if(suffix.length() == 0){
			results.add(prefix);
		} else {
			for(int i=0; i<suffix.length(); i++){
				permutations(prefix + suffix.charAt(i), 
							 // We remove the character at position "i" from String
							 suffix.substring(0, i) + suffix.substring(i+1, suffix.length()),   
							 results);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> s = permutations("abc");
		
		Iterator<String> i = s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		/**
		 * Important: String substring(int startIndex, int endIndex)
		 * - startIndex: inclusive
		 * - endIndex: exclusive
		 */
		//System.out.println("abc".substring(2,3)); 
	    //System.out.println("cde".substring(1, 2));
		
		
	}
}
