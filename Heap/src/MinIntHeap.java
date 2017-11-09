import java.util.Arrays;

public class MinIntHeap {

	private int capacity = 10;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexTwo] = items[indexOne];
		items[indexOne] = temp;
	}
	
	private void ensureExtraCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		
		return items[0];
	}
	
	/**
	 * 				10
	 * 			15		20
	 * 		17
	 * @return
	 */
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		
		int item = items[0];			// 1. Return the first value	
		items[0] = items[size - 1];		// 2. Take the very last element of the array an put it in the first
										// 	  Move 17 to position 0
		size--;							// 3. Shrink the array
		heapifyDown();
		
		return item;
	}
	
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	public void heapifyDown() {
		int index = 0;	// 1. we begin with index 0
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);	// 2. Add the smaller index with the first index of the left

			// 3. If there's a rightChild and this is smaller than left child we set the new Smaller
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) { 
				smallerChildIndex = getRightChildIndex(index);
			}
			
			// 4. If I'm the smaller everything is good and we break!
			if(items[index] <items[smallerChildIndex]){
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}
	
	
}
