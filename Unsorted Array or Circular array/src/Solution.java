
public class Solution {
	
	// TEST
	// 2, 3, 4, 5, 1
	//          ^
	// item = 5
	// Length = 5
	// offset: length - array[0] + 1 = 5 - 2 + 1 = 4
	// Position: item + offset - length - 1 = 5 + 3 - 5: 3 
	static public int indexK(int item, int[] array){
		int length = array.length;
		int position = 0;
		
		if(length == 0){
			return -1;
		}
		
		int offset = length - array[0] + 1;
		if(offset == length) offset = 0;
		
		
		if(item >= array[0]){
			position = item + offset - length - 1;
		} else {
			position = item + offset - 1;
		}
		
		return array[position] == item ? position : -1;
		
	}
	
	static int calculateArraySearch(int array[], int item) {
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
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
		
		//int index = indexK(63, numbers); // This not work for any order array. Just for the one that begin with 1, 2, 3, ...
		
		int index = calculateArraySearch(numbers, 2);
		
		System.out.println("Position is: " + index);
		
	}
}
