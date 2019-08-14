
/**
 * How to Find Middle Element of Linked List in Java in Single Pass
 * This question is similar to checking palindrome or calculating the factorial.
 * 
 * - Since in order to find middle element of Linked List you need to find the length 
 * of linked list, which is counting elements till end i.e. until you find the last element of Linked List.
 * 
 * - What makes this data structure Interview question interesting is that you need 
 * to find the middle element of LinkedList in one pass and you don’t know the length of LinkedList.
 * 
 * Solution: In order to find middle element of linked list in one pass, you need to maintain 
 * two-pointer, one increment at each node while other increments after two nodes at a time, 
 * by having this arrangement, when the first pointer reaches the end, the second pointer will 
 * point to a middle element of the linked list. 
 * @author jorgecasariego
 *
 */
public class MiddleElement {
	public static void main(String[] args) {	
		
		LinkedList linkedList = new LinkedList();
		LinkedList.Node head = linkedList.head();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		
		// finding middle element of LinkedList in single pass
		LinkedList.Node current = head;
		int length = 0;
		LinkedList.Node middle = head;
		
		// linkedList: h 1 2 3 4
		// current:            -
		// middle:         *
		// length =    0 1 2 3 4
		
		while(current.next() != null) {
			length++;
			if(length % 2 == 0) {
				middle = middle.next();
			}
			
			current = current.next();
		}
		
		if (length % 2 == 1) {
			middle = middle.next();
		}
		
		System.out.println("Lenght of the linked list is " + length);
		System.out.println("middle element of LinkedList: " + middle);
	}
}

class LinkedList {
	private Node head;
	private Node tail;
	
	public LinkedList() {
		this.head = new Node("head");
		tail = head;
	}
	
	public Node head() {
		return head;
	}
	
	/*
	 * 1) Inicialmente
	 * head = head 
	 * tail = head
	 * 
	 * 2) llega 1
	 * tail.next = head.next = 1
	 * tail = 1
	 * 
	 * 3) llega 2
	 * tail.next = 1.next = 2
	 * tail = 2
	 */
	 
	public void add(Node node) {
		tail.next = node;
		tail = node;
	}
	
	
	public static class Node {
		private Node next;
		private String data;
		
		public Node(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
		
		public String toString() {
			return this.data;
		}
		
	
	}
}
