import java.util.PriorityQueue;

/**
 * This problem can be solved by using a heap. The time is O(n log(n)).
 * 
 * Given m arrays, the minimum elements of all arrays can form a heap. 
 * It takes O(log(m)) to insert an element to the heap and it takes O(1) 
 * to delete the minimum element.
 * 
 * 
 * @author jorgecasariego
 *
 */
public class KSortedArray implements Comparable<KSortedArray>{
	// index of the array, index within the array, the value at that index
	int array, index, value;
	
	public KSortedArray(int array, int index, int value){
		this.array = array;
		this.index = index;
		this.value = value;
	}
	
	public int compareTo(KSortedArray n){
		if(value > n.value) return 1;
		if(value < n.value) return -1;
		return 0;
	}
	
	// 1. First we're going to create a priority queue:
	//		- The elements of the priority queue are ordered according to their natural ordering, 
	//		  or by a Comparator provided at queue construction time, depending on which 
	//		  constructor is used.
	// 		- A priority queue does not permit null elements.
	//		- A priority queue relying on natural ordering also does not permit insertion of non-comparable objects.
	// 2. We're going to add the first element from each array
	// 3. Then, we're going to remove elements from the priority queue
	//    and using that element we're going to know what element to get
	//	  to add to the priority queue next. And we're just going to iterate
	// 	  through the priority queue until the priority queue is empty. 
	/**
	 * {1, 3, 5}
	 * {2, 4}
	 * @param arrays
	 * @return
	 */
	public static int[] merge(int[][] arrays){
		PriorityQueue<KSortedArray> pq = new PriorityQueue<KSortedArray>();
		
		int size = 0;
		
		// We put every element of the position 0 into the pq
		for(int i=0; i<arrays.length;i++){
			size += arrays[i].length;
			
			if(arrays[i].length > 0){
				// index of array, index within the array, value
				pq.add(new KSortedArray(i, 0, arrays[i][0]));
			}
		}
		
		// Then we need to create the array of results and compares values of the pq
		// and save the smallest value into result
		int[] result = new int[size];
		for(int i=0; !pq.isEmpty(); i++){
			KSortedArray n = pq.poll(); // Remove the first element
			result[i] = n.value;
			int newIndex = n.index + 1;
			if(newIndex < arrays[n.array].length){
				//PriorityQueue do the MAGIC of insert the new element ordered in pq
				pq.add(new KSortedArray(n.array, newIndex, arrays[n.array][newIndex]));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 4, 9},
				{2, 7},
				{3, 5, 6},
				{8}
		};
		
		int[] result = merge(matrix);
		
		printArray(result);
	}
	
	/* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
