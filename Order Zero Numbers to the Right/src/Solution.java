
public class Solution {

	// TEST
	//  6, 4, 0, 5, 0, 0, 0, 1, 0
	//						    ^
	//  ^                   
	public static int[] orderArray(int[] numbers){
		
		int last = numbers.length - 1;
		int first = 0;
		int[] newArray = new int[numbers.length];
		
		for(int i = 0; i < last; i++){
			if(numbers[i] == 0){
				newArray[last--] = 0;
			} else {
				newArray[first++] = numbers[i];
			}
		}
		
		return newArray;
	}
	
	// TEST
	// With this we're no using a new array
	// We're just moving zeros to the last known position 
	public static void order(int[] numbers){
		int last = numbers.length - 1;
		
		for(int i = 0; i < last; i++) {
			if(numbers[i] == 0){
				swap(numbers, i, last--);
			}
		}
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[j] = numbers[i];
		numbers[i] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[]{ 6, 4, 0, 5, 0, 0, 0, 1, 0 };
		
		int[] orderArray = orderArray(numbers);
		
		for(int i: orderArray){
			System.out.print(i + " ");
		}

		System.out.println();
		order(numbers);
		
		for(int i: orderArray){
			System.out.print(i + " ");
		}
		
	}
}
