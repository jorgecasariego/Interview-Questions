import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {
	
	public static void printAllTree(SortedSet<Integer> tree){
		for(int n: tree) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		Integer[] numbers = {2, 4, 1, 7, 5, 0, 8, 3};
		SortedSet<Integer> tree = new TreeSet<>(Arrays.asList(numbers));
		
		//Print the first and the last element
		System.out.println(tree.first());
		System.out.println(tree.last());
		
		// All elements of tree
		// 0 1 2 3 4 5 7 8 head 7 
		System.out.println("All elements of tree");
		printAllTree(tree);
		
		// head 7
		// 0 1 2 3 4 5
		System.out.println("head 7");
		printAllTree(tree.headSet(7));
		
	}
}
