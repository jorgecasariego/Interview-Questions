import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap in Java  is sorted according to the natural ordering of its keys, 
 * or by a Comparator provided at map creation time, depending on which constructor is used.
 * 
 * This proves to be an efficient way of sorting and storing the key-value pairs. 
 * The storing order maintained by the treemap must be consistent with equals just like any 
 * other sorted map, irrespective of the explicit comparators. The treemap implementation is 
 * not synchronized in the sense that if a map is accessed by multiple threads, concurrently 
 * and at least one of the threads modifies the map structurally, it must be synchronized 
 * externally.
 *  
 * @author jorgecasariego
 *
 */
public class TreeMapDemo {
	
	public static void printAllTreeMap(TreeMap<String, Double> tree){
		
		for(Map.Entry<String, Double> city: tree.entrySet()){
			System.out.println(city.getKey() + " : " + city.getValue());
		}
		
		System.out.println("");
	}

	public static void main(String[] args){
		TreeMap<String, Double> tree  = new TreeMap<>();
		
		tree.put("Pozo Colorado", 57.32);
		tree.put("Asunción", 23.54);
		tree.put("Encarnacion", 43.21);
		tree.put("Ciudad del este", 10.21);
		tree.put("Caazapa", 41.74);
		tree.put("Canindeyu", 9.32);
		
		// Result:
		/*
		 * 	Asunción : 23.54
		 * 	Caazapa : 41.74
		 * 	Canindeyu : 9.32
		 * 	Ciudad del este : 10.21
		 * 	Encarnacion : 43.21
		 * 	Pozo Colorado : 57.32
		 */
		printAllTreeMap(tree);
		
	}
}
