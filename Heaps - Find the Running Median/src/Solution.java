import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	
	public static void addNumber(int number, 
								PriorityQueue<Integer> lowers, 
								PriorityQueue<Integer> highers) {
		
		if(lowers.size() == 0 || number < lowers.peek()){
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}
	
	public static void rebalance(PriorityQueue<Integer> lowers, 
								 PriorityQueue<Integer> highers) {
		// PQ with Most elements go to Bigger
		PriorityQueue<Integer> biggerHeap = 
				lowers.size() > highers.size() ? 
						lowers : highers;
		// PQ with Less elements go to Smaller		
		PriorityQueue<Integer> smallerHeap = 
				lowers.size() > highers.size() ? 
						highers : lowers;
		
		if(biggerHeap.size() - smallerHeap.size() >= 2){
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, 
								   PriorityQueue<Integer> highers) {
		// PQ with Most elements go to Bigger
		PriorityQueue<Integer> biggerHeap = 
				lowers.size() > highers.size() ? 
						lowers : highers;
				
		// PQ with Less elements go to Smaller
		PriorityQueue<Integer> smallerHeap = 
				lowers.size() > highers.size() ? 
						highers : lowers;
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else {
			return biggerHeap.peek();
		}
	}
	/*
	 * 1. It's going to take an integer array and return an array of doubles.
	 * We need to use a double here to store the median because the median 
	 * might be an average of two differents integers. 
	 */
	public static double[] getMedians(int[] array) {
		// 2. Here we're implementing two heaps using PriorityQueues
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer> (
				// 3. We use comparator to change the way it works. We want to put the 
				// biggest element on top
				new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return -1 * a.compareTo(b);
					}
				}
		);
		
		// 4. Here we didn't change anything. Top will be the min value.
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		
		// 5. 
		double[] medians = new double[array.length];
		for(int i = 0; i < array.length; i++) { // N
			int number = array[i];
			addNumber(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		
		return medians;
		
	}
	/*
	 	1.0
		1.5
		2.0
		2.5
		3.0
		3.5
		4.0
		4.5
		5.0
		5.5
	 */
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// Get medians of every value of the array
        double[] medians = getMedians(a);
        for(int i = 0; i < medians.length; i++) {
            System.out.println(medians[i]);
        }
	}
}
