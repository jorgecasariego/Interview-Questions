import java.util.ArrayList;
import java.util.Iterator;

public class PermutationIntegers {

	public static ArrayList<int[]> integerPermutation(int[] a){
		ArrayList<int[]> results = new ArrayList<>();
		
		listPermutations(a, 0, results);
		
		return results;
	}
	
	private static void listPermutations(int[] a, int start, ArrayList<int[]> results){
		if(start >= a.length){
			results.add(a.clone());
		} else {
			for(int i=start; i<a.length; i++){
				swap(a, start, i);
				listPermutations(a, start+1, results);
				swap(a, start, i);
			}
		}
	}
	
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 2, 3, 4};
		ArrayList<int[]> result = integerPermutation(numbers);
		
		Iterator<int[]> i = result.iterator();
		
		while(i.hasNext()){
			int[] values = i.next();
			System.out.print("{");
			for(int j=0; j<values.length; j++){
				System.out.print(values[j] + ",");
			}
			System.out.println("}");
			
		}
	}
}
