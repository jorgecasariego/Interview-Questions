import java.util.Arrays;

/**
 * 
 * Find the point where maximum intervals overlap
 * Consider a big party where a log register for guest’s entry and exit times is maintained. 
 * Find the time at which there are maximum guests in the party. 
 * Note that entries in register are not in any order.

	Example:
	********
	Input: arrl[] = {1, 2, 9, 5, 5}
	       exit[] = {4, 5, 12, 9, 12}
	First guest in array arrives at 1 and leaves at 4, 
	second guest arrives at 2 and leaves at 5, and so on.
	
	Output: 5
	There are maximum 3 guests at time 5.  
	
 * 
 * @author jorgecasariego
 *
 */
public class Solution {

	/**
	 * 
	 * Sort both arrays: 
	 * arrl[] = {1, 2, 5, 5, 9}
	 * exit[] = {4, 5, 9, 12, 12}
	 * 
	 * Time		Event Type		Guests
	 * ****		**********		******
	 * 1		Arrival			1
	 * 2		Arrival			2
	 * 4		Exit			1
	 * 5		Arrival			2
	 * 5		Arrival			3	// Max Guests
	 * 5		Exit			2
	 * 9		Arrival			3
	 * 9		Exit			2
	 * 12		Exit			1
	 * 12		Exit			0			
	 * 
	 * @param arrivals
	 * @param exits
	 * @param n
	 */
	public static void findMaxGuests(int[] arrival, int[] exit, int n) {
		Arrays.sort(arrival);
		Arrays.sort(exit);
		
		int guests = 1;
		int max = 1;
		int i = 1;
		int j = 0;
		int time = arrival[0];
		
		while(i < n && j < n) {
			if(arrival[i] <= exit[j]) {
				guests++;
				
				if(guests > max) {
					max = guests;
					time = arrival[i];
				}
				
				i++;
			} else {
				guests--;
				j++;
			}
		}
		
		System.out.println("Maximun number of guests are " + max + " at time " + time);
	}
	
	// Driver program to test above function
    public static void main(String[] args){
    	
        int arrl[] = {10, 5, 5, 1, 2};
        int exit[] = {12, 9, 12, 4, 5};
        int n = arrl.length;
        
        findMaxGuests(arrl, exit, n);
    }
}
