import java.util.HashSet;
import java.util.Iterator;

public class RemoveDupFromLinkedList {
	public static class Node {
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
		}
	}
	
	/*
	 * We know that the linked list is ordered:
	 *  input: 1 -> 1 -> 2 -> 2 -> null
	 *   - n                         ^
	 *   - prev            ^-------->null
	 *  saved: 1
	 *  
	 *  save the unique elements on a HashSet<Integer>
	 *  
	 *  Time Complexity: O(n) on average (Assuming that hash table access time is O(1))
	 */
	public static void removeDuplicate(Node n){
		HashSet<Integer> savedElements = new HashSet<Integer>();
		Node prev = null;
		
		while(n != null){
			if(!savedElements.contains(n.value)){
				savedElements.add(n.value);
				prev = n;
			} else  {
				prev.next = n.next;
			}
				
			n = n.next;
		}
		prev.next = null;
	}
	
	public static void printList(HashSet<Integer> elements){
		Iterator<Integer> i = elements.iterator();
		
		System.out.print(" -> ");
		while(i.hasNext()){
			System.out.print(i.next() + " -> ");
		}
		
		System.out.println("null");
	}
	
	public static void printLinkedList(Node n){
		while(n != null){
			System.out.print(n.value + " -> ");
			n = n.next;
		}
		
		System.out.println("null");
	}
	
	public static void main(String[] arg){
		Node node1 = new Node(1);
		Node node1a = new Node(1);
		Node node2 = new Node(2);
		Node node2a = new Node(2);
		
		node1.next = node1a;
		node1a.next = node2;
		node2.next = node2a;
		System.out.println("Before removing duplicates");
		printLinkedList(node1);
		
		removeDuplicate(node1);
		
		System.out.println("");
		System.out.println("After removing duplicates");
		printLinkedList(node1);
		
	}
}
