
public class Solution {
	
	static long countInversions(int[] arr) {
        return mergesort(arr, 0, arr.length-1);
        
    }
   
	static long mergesort(int[] array, int l, int r) {
		if(l == r)
			return 0;
		
        int m = (l + r) / 2;
        long inversions = 0;
        inversions += mergesort(array, l, m);
        inversions += mergesort(array, m + 1, r);
        inversions += merge(array, l, r);
        
        return inversions;
        
    }
    
    static long merge(int[] array, int l, int r){
        int m = (l + r) / 2;
        
        int[] aux = new int[r - l + 1];
        int current = 0;
        int i = l;
    	int j = m + 1;
    	
        long inversions = 0;
    	
        while(i <= m && j <= r){
            if(array[i] <= array[j]){
                aux[current++] = array[i++];
            } else {
                aux[current++] = array[j++];
                
                // I need to use index "i" to know how many values are before m and this are all inversions!
                inversions += m - i + 1; 
            }
        }
        
        while(i <= m){
            aux[current++] = array[i++];
        }
        
        while(j <= r) {
            aux[current++] = array[j++];
        }
        
        System.arraycopy(aux, 0, array, l, r - l + 1);
        
        return inversions;
    }
	
	public static void main(String[] args) {
		int array[] = {2, 1, 3, 1, 2};
		
		System.out.println("Given an array");
		printArray(array);
		
		long count = countInversions(array);
		System.out.println("Count is " + count);
		
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
