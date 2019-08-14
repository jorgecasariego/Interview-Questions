import java.util.Arrays;
import java.util.PriorityQueue;

/*
	Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

	Example 1:
	
	Input: [3,2,1,5,6,4] and k = 2
	Output: 5
	Example 2:
	
	Input: [3,2,3,1,2,4,5,5,6] and k = 4
	Output: 4
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Main {
	public static void main(String[] args) {
		int[] numbers = {3,2,1,5,6,4};
		int k = 2;
		
		System.out.println("The kths largest (1) number is " + findKthLargest(numbers, k));
		System.out.println("The kths largest (2) number is " + findKthLargest2(numbers, k));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		
		return nums[nums.length - k];
	}
	
	public static int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue();
		
		for(int i = 0; i < nums.length; i++) {
			minHeap.add(nums[i]);
			
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.poll();
	}
}
