
public class MergeSort {
	void mergeSort(int array[], int l, int r){
		if(l<r){
			int m = (l + r) / 2; 
			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			merge(array, l, m, r);
		}
	}
	
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
	public void merge(int[] array, int l, int m, int r){
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;
		
		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		/*Copy data to temp arrays*/
		for(int i=0; i<n1; i++){
			L[i] = array[l + i];
		}
		
		for(int j=0; j<n2; j++){
			R[j] = array[m + 1 + j];
		}
		
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		
		// Initial index of merged subarry array
		int k = l;
		while(i < n1 && j < n2){
			if(L[i] <= R[j]){
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		/* Copy remaining elements of L[] if any */
		while(i<n1){
			array[k] = L[i];
			i++;
			k++;
		}
		
		/* Copy remaining elements of R[] if any */
		while(j<n2){
			array[k] = R[j];
			j++;
			k++;
		}	
	}
	
	public static void main(String[] args) {
		int array[] = {12, 11, 13, 5, 6, 7};
		
		System.out.println("Given an array");
		printArray(array);
		
		MergeSort ms = new MergeSort();
		ms.mergeSort(array,0, array.length-1);
		
		System.out.println("Sorted array: ");
		printArray(array);
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
