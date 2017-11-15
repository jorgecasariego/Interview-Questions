/**
 * Given an array containing all the numbers from 1 to n except two, find the two missing numbers.
 * 
 * Example
 * *******
 * missing([4, 2, 3]) = 1, 5
 * 
 * @author jorgecasariego
 *
 */
public class Solution {

	// This works if in the array is missing one element
	public static int oneMissing(int[] numbers) {
		int totalXOR = 0;
		int arrXOR = 0;
		
		for(int i = 1; i <= numbers.length + 1; i++) {
			totalXOR ^= i;
		}
		
		for(int i : numbers) {
			arrXOR ^= i;
		}
		
		// Automatically remove the ones that are equals
		// 2^1^7^4^5^6 ^ 1^2^3^4^5^6^7 = 3
		return totalXOR ^ arrXOR;
	}
	
	// TEST
	// [1, 2, 3, 4, 5, 6] = 21
	// [1, 2, 5, 6]	= 14
	public static int[] twoMissing(int[] numbers) {
		int size = numbers.length + 2;
		
		// This is the total sum of the complete array
		long totalSum = size * (size + 1) / 2;
		
		// This is the total sum of the partial array without 2 elements
		long partialArraySum  = 0;
		for(int i: numbers){
			partialArraySum +=i;
		}
		
		// We will calculate the pivot of the partial array
		int pivot = (int)((totalSum - partialArraySum) / 2);
		
		int totalLeftXor = 0;
		int arrLeftXor = 0;
		
		int totalRightXor = 0;
		int arrRightXor = 0;
		
		// I'm creating this if pivot is 3
		// totalLeftXor: 1^2^3
		for(int i = 1; i <= pivot; i++){
			totalLeftXor ^=i;
		}
		
		// totalRight: 4^5^6^7
		for(int i = pivot + 1; i <= size; i++){
			totalRightXor ^=i;
		}
		
		for(int i: numbers){
			if(i <= pivot) {
				arrLeftXor ^= i;
			} else {
				arrRightXor ^= i;
			}
		}
		
		
		return new int[] {totalLeftXor^arrLeftXor, totalRightXor^arrRightXor};
	}
	
	public static void main(String[] args) {
		int[] numbers1 = {2,1,7,4,5,6};
		
		int result = oneMissing(numbers1);
		
		System.out.println("The element missing in the array is " + result);
		
		int[] numbers2 = {7,2,4,1,6};
		int[] result2 = twoMissing(numbers2);
	
		
		System.out.println("The two elements missing in the array are " + result2[0] +" && "+ result2[1]);
	}
}
