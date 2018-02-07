import java.util.HashMap;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 */
public class Main {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15};
		int target = 26;
		//int[] solution = solution1(nums, target); 
		int[] solution = solution2(nums, target); 
		
		if(solution == null){
			System.out.println("No solution");
		} else {
			for(int index : solution){
				System.out.println("index : " + index);
			}
		}
		
	}

	/*
	 	Complexity Analysis

		Time complexity : O(n^2). 
		For each element, we try to find its complement by looping through the rest of 
		array which takes O(n) time. Therefore, the time complexity is O(n^2).

		Space complexity : O(1)
	 */
	private static int[] solution1(int[] nums, int target) {
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(nums[i] + nums[j] == target){
					return new int[] {i, j};
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Complexity Analysis:
	 * Time complexity : O(n). We traverse the list containing n elements only once. Each look up
	 * int the table cost only O(1) time.
	 * 
	 * Space complexity: O(n). The extra space required depends on the number of items stored
	 * in the hash table, which stores at most n elements
	 */
	private static int[] solution2(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			int complement = target - nums[i];
			
			if(map.containsKey(complement)){
				return new int[] { map.get(complement) , i};
			}
			
			map.put(nums[i], i);
		}
		
		return null;
	}
}
