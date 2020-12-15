import java.util.Stack;

public class Palindromes {
	
	/*
	 * Linked List Node
	 */
	public static class Node {
		int value;
		Node next;
		
		Node(int v){
			this.value = v;
		}
		
	}
	/*
	 * 	In this implementation we have 2 pointers: 1 the current pointer going one by one and the other going the double
	 * of steps from the current pointer. So, when the runner is coming to the end the current pointer is coming to the
	 * middle of the list.
	 *
	 * If runner is not null it means that the number of nodes is odd so we must move current one more position.
	 * 				1 -> 2 -> 2 -> 1 -> null
	 * current:		                     ^
	 * runner: 		                     ^
	 * stack: 		[1,2]
	 * 
	 */
	public static boolean isPalindrome(Node n){
		Stack<Integer> stack = new Stack<Integer>();
		Node current = n;
		Node runner = n;
		
		while(runner != null && runner.next != null){
			stack.push(current.value);
			current = current.next;
			runner = runner.next.next;
		}
		
		if(runner != null){
			current = current.next;
		}
		
		while(current != null){
			if(stack.pop().intValue() != current.value){
				return false;
			}
			
			current = current.next;
		}
		
		return true;
	}

	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******
	
	public static boolean isPalindrome(String s){
		s = s.toLowerCase();
		
		if(s.length() < 2){
			return true;
		} else {
			char first = s.charAt(0);
			char last = s.charAt(s.length() - 1);
			if(first == last) {
				// It is very common to call isPalindrome but not returning nothing.
				return isPalindrome(s.substring(1, s.length() - 1)); // This is really important!
			} else {
				return false;
			}
		}		
	}

	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******
	// LeetCode: 5. Longest Palindromic Substring
	// Time Complexity: O(n^2). Since expanding a palindrome around its center could take O(n) time,
	// the overall complexity is O(n^2)
	// Space complexity: O(1)
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}

		int start = 0;
		int end = 0;

		// In this for loop we're gonna manage the 2 possible String palindromes:
		// 1: abba
		// 2: racecar
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i); 	// this is for the option 2. Left and right will be pointing to the letter 'e'
			int len2 = expandFromMiddle(s, i, i+1);	// this is for the option 1
			int len = Math.max(len1, len2);

			// This is for get the new longest palindrimo substring
			if (len > end - start) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}

			// Example: racecar
			// len = 7
			// i = 3
			// start = 3 - (7 - 1) / 2 = 3 - 6/2 = 0
			// end = 3 + (7/2) = 3 + 3 = 6
		}

		return s.substring(start, end + 1);
	}

	// In this method we take a String, expand from the middle of the String or from some point  in the String and fin
	// the palindrome
	public static int expandFromMiddle(String s, int left, int right) {
		if (s == null || left > right) {
			return 0;
		}

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		// abbc
		//  12		left = 1, right = 2
		// return 2 - 1 - 1 = 0

		return right - left - 1;
	}

	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******	//*******
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		if(isPalindrome(n1)){
			System.out.println("The linked list is a palindrome");
		} else {
			System.out.println("The linked list is not a palindrome");
		}
		
		System.out.println("AM : " + isPalindrome("AM"));
		System.out.println("AMAR : " + isPalindrome("AMAR"));
		System.out.println("Amore, Roma: " + isPalindrome("AmoreRoma"));
		System.out.println("AMA: " + isPalindrome("AMA"));

		System.out.println("babad: " + longestPalindrome("babad"));
		System.out.println("gfdgfdracecarfsfss: " + longestPalindrome("gfdgfdracecarfsfss"));
	}

}
