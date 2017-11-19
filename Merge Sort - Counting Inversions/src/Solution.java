/**
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
 * If array is already sorted then inversion count is 0. 
 * If array is sorted in reverse order that inversion count is the maximum. 
 * 
 * 
 * @author jorgecasariego
 *
 */
public class Solution {
	
	static int inversions;
	
	public static void countInversionsQuick(int[] array) {
		quicksort(array, 0, array.length-1);
	}
	
	public static void quicksort(int[] array, int l, int r){
		if(l >= r){
			return;
		}
		
		int pivot = (l + r) / 2;
		int index = partition(array, l, r, pivot);
		
		quicksort(array, l, index - 1);
		quicksort(array, index, r);
		
	}
	
	// TEST
	// 		9, 2, 6, 4, 3, 5, 1		-->  1, 2, 6, 4, 3, 5, 9
	// 		^		 ^	      ^			    ^     ^	    ^
	// 	   left		pivot	right		  left	pivot  right
	public static int partition(int[] array, int l, int r, int pivot){
		while(l <= r){
			if(array[l] < pivot){
				l++;
			}
			
			if(array[r] >= pivot){
				r--;
			}
			
			if(l <= r){
				swap(array, l, r);
				inversions++;
				l++;
				r--;
			}
		}
		
		return l;
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//************************************************************************
	
	static long countInversions(int[] arr) {
        return mergesort(arr, 0, arr.length-1);
        
    }
   
	// {2, 1, 3, 1, 2};
	// m = (0 + 4) / 2 = 2
	// ms(0, 2)
	//	m = (0+2)/2 = 1
	//	ms(0, 1)
	//		m = (0+1)/2 = 0
	// 		
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
	
	//  {2, 1, 3, 1, 2};
	// 		merge(0, 1)
	//		m = 0
	//		aux [2] = [1]
	//	i = 0
	//	j = 2
	//  current = 1
	// 	inversions = 
	// 2 <= 1
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
                
                // I need to use index "i" to know how 
                // many values are before m and this are all inversions!
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
		
		//long count = countInversions(array);
		//System.out.println("Count is " + count);
		
		inversions = 0;
		countInversionsQuick(array);
		System.out.println("Count is " + inversions);
		
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
