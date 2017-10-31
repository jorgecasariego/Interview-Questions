import java.util.HashSet;
import java.util.Set;

public class Dedup {
	
	static class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
		
	}
	
	// Test: 1 -> 2 -> 3 -> 2 -> 1
	// Set: [1, 2, 3]
	// List = 2, 3, null
	// prev = 1, 2, 3
	public static void dedup(Node list) {
		Set<Integer> numbers = new HashSet<>();
		Node prev = null;
		
		while(list != null) {
			if(!numbers.contains(list.data)){
				numbers.add(list.data);
				prev = list;
				list = list.next;
			} else {
				prev.next = list.next;
				list = list.next;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		dedup(node1);
		
		while(node1 != null){
			System.out.print(node1.data + " -> ");
			node1 = node1.next;
		}
		
		System.out.println("null");
	}
}
