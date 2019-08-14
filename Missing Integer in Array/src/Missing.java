/**
 * - You have given an integer array of size N. 
 * - Array contains numbers from 1 to N-1 but a couple of numbers 
 *   are missing in an array which also contains duplicates
 *   
 * - For example, if given array is {1, 1, 2, 3, 5, 5, 7, 9, 9, 9} 
 *   then it has length 10 and contains a number from 1 to 9. 
 *   In this case, missing numbers are 4, 6, and 8
 *   
 * Solution 1:
 * We can use an array as register and it's an index as names of the numbers. 
 * You need to loop through the given array and tick marking all the numbers 
 * which are present by storing one of their respective indices. 
 * For example, if the first number in the given array is 5 
 * (since the array is not sorted) then we store 1 on index 5 e.g. register[5] = 1
 * 
 * Once we have gone through all the numbers is given, we can go through our 
 * register array and print all the indices where the value is zero. 
 * These are absentees or missing numbers.
 * @author jorgecasariego
 *
 */
public class Missing {
	public static void main(String[] args) {
		
		// give input
		int[] input = {1, 1, 2, 3, 3, 5, 5, 7, 9, 9 };
		
		// let's create another array with same length
	    // by default all index will contain zero
	    // default value for int variable
		int[] register = new int[input.length];
		
		// now let's iterate over given array to
	    // mark all present numbers in our register
	    // array
		for(int i: input) {
			register[i] = 1;
		}
		
		// now, let's print all the absentees
	    System.out.println("missing numbers in given array");
	    
	    for(int i=0; i < register.length; i++) {
	    	if (register[i] == 0) {
	    		System.out.print(i + " ");
	    	}
	    }
		
	    // Big O
	    // Space Complexity: O(n)
	    // O(n) for iterate all the numbers
	    // O(n) for iterate register array
	    // O(n) + O(n) = O(2n) = O(n)

	    // Problem 2:
	    /*
			Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

			Example 1:
			
			Input: [3,0,1]
			Output: 2
			Example 2:
			
			Input: [9,6,4,2,3,5,7,0,1]
			Output: 8
	     */
	    System.out.println("");
	    int[] input2 = { 9,6,4,2,3,5,7,0,1 };
	    System.out.println("The missing number is: " + missingNumber(input2));
	    
	}
	
	public static int missingNumber(int[] nums) {
		int sum = 0;
		for(int num: nums) {
			sum += num;
		}
		
		int n = nums.length;
		return n*(n+1)/2 - sum;
	}

}
