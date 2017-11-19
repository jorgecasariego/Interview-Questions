/**
 * # String Compression
 * *********************
 * 
 * Given a string, write a function to compress it by shortening every sequence of 
 * the same character to that character followed by the number of repetitions.
 * 
 * If the compressed string is longer than the original, 
 * you should return the original string
 * 
 * Example:
 * 
 * Compress("a") = a
 * Compress("aaa") = a3
 * Compress("aaabbb") = a3b3
 * Compress("aaabccc") = a3cb3
 * 
 * @author jorgecasariego
 *
 */
public class Compress {

	public static String compress(String s) {
		String output = "";
		int sum = 1;
		
		// aaa | aaab
		//  ^  |   ^
		// output = a3 | a3b1
		// sum = 3 | 3 | 1
		for(int i=0; i < s.length() - 1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				sum++;
			} else {
				output = output + s.charAt(i) + sum;
				sum = 1;
			}
		}
		
		output = output + s.charAt(s.length() - 1) + sum;
		
		return output.length() > s.length() ? s : output;
		
	}
	
	public static void main(String[] args){
		System.out.println(compress("aaa"));
		System.out.println(compress("a"));
		System.out.println(compress("aaabccc"));
		System.out.println(compress("aabc"));
	}
}
