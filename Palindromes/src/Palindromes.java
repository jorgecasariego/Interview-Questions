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
	}

}
