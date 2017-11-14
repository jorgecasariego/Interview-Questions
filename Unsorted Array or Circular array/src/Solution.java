/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * 
 * But suppose we rotate an ascending order sorted array at some pivot unknown 
 * to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
 * Devise a way to find an element in the rotated array in O(log n) time.
 * 
 * @author jorgecasariego
 *
 */
public class Solution {
	
	/**
     *	 	1) Find middle point mid = (l + h)/2
     *		2) If key is present at middle point, return mid.
     *		3) Else If arr[l..mid] is sorted
     *    		a) If key to be searched lies in range from arr[l] to arr[mid], recur for arr[l..mid].
     *    		b) Else recur for arr[mid+1..r]
     *		4) Else (arr[mid+1..r] must be sorted)
     *    		a) If key to be searched lies in range from arr[mid+1] to arr[r], recur for arr[mid+1..r].
     *    	b) Else recur for arr[l..mid]
     *	 
	 * @param array
	 * @param item
	 * @return
	 * 
	 * Time Complexity O(logn). 
	 */
	static int calculateArraySearch(int array[], int item) {
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2; 	// Find middle point
			
			if(item == array[mid]) {		// Case 1: Found item!!!
				return mid;
			}
			
			if(array[mid] <= array[right]) {	// Case 2: right half is sorted
				if(item > array[mid] && item <= array[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {							// Case 3: left half is sorted (array[left] <= array[mid])
				if(array[left] <= item && item < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int [] numbers = {55, 63, 110, 2, 3, 4};
				
		int index = calculateArraySearch(numbers, 2);
		
		System.out.println("Position is: " + index);
		
	}
}
