/*
 * Find and print all subsets of a given set
 * 
 * For example: {1,2}
 * ------------------
 * 			         {1,2}						// We create subset by index, and when index = 2 print
 * 		    {0,0}	           {1, 0} 		    // i = 0
 * 	   {0,0}    {0,2}     {1,0}     {1,2}		// i = 1
 * 												// i = 2 --> print all subsets
 * 
 * Amount of result is: 2^n --> n=2 --> result: 4
 */
public class AllSubsets {

	public static void allSubsets(int[] array){
		int[] subSet = new int[array.length];
		helper(array, subSet, 0);
	}
	
	public static void helper(int[] array, int[] subSet, int index){
		if(index == array.length){
			print(subSet);
		} else {
			subSet[index] = 0;
			helper(array, subSet, index+1);
			
			subSet[index] = array[index];
			helper(array, subSet, index+1);
		}
	}
	
	public static void print(int[] array){
		if(array != null){
			System.out.print("[");
			for(int i=0; i<array.length; i++){
				System.out.print(array[i] + ",");
			}
			System.out.println("]");
		}
		
	}
	
	public static void main(String[] args){
		int[] array = {1, 2};
		allSubsets(array);
	}
}
