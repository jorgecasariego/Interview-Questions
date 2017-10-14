
public class LinkedList {
	// reference to the head node
	private Node head;
	private int listCount;
	
	public LinkedList(){
		// This is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new Node(null);
		listCount = 0;
	}
	
	public void addObject(Object data){
		// post: appends the specified element to the end of this list
		Node temp = new Node(data);
		Node current = head;
		
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null){
			current = current.getNext();
		}
		
		// the last node's next reference set to our new node
		current.setNext(temp);
		// increment the number of elements variable
		listCount++;
	}
	
	public void addObject(Object data, int index){
		// post: insert the object at the specified position in this list
		Node temp = new Node(data);
		Node current = head;
		
		// crawl to the requested index or the last element in the list, 
		// whichever come first
		for(int i=1; i<index && current.getNext() != null; i++){
			current = current.getNext();
		}
		
		// set the new node's next node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;
	}
	
	public Object getIndex(int index){
		// post: return the element at the specified position in this list
		//index must be 1 or higher
		if(index <= 0){
			return null;
		}
		
		Node current = head.getNext();
		for(int i=1; i<index; i++){
			if(current.getNext() == null){
				return null;
			}
			
			current.getNext();
		}
		
		return current.getData();
	}
	
	public boolean remove(int index){
		//post: we remove the element at the specified position in this list
		//if the index is out of range, exit
		if(index < 1 || index > size()){
			return false;
		}
		
		Node current = head;
		for(int i= 1; i<index; i++){
			if(current.getNext() == null){
				return false;
			}
			
			current = current.getNext();
		}
		//We're here before the position of the index, that's the reason we're doing two times getNext()
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}
	
	public int size(){
		return listCount;
	}
	
	public String toString(){
		Node current = head.getNext();
		String output = "";
		while(current != null){
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		
		return output;
	}
	
	private class Node {
		// reference to the next node in the chain
		// or null if there isn't one
		Node next;
		
		// data carried by this node
		// could by of any kind of data
		Object data;
		
		// Node constructor
		public Node(Object data){
			next = null;
			this.data = data;
		}
		
		// another constructor if we want to specify
		// the node to point to
		public Node(Object data, Node next){
			this.next = next;
			this.data = data;
		}
		
		public Object getData(){
			return data;
		}
		
		public void setData(Object data){
			this.data = data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		System.out.println(linkedList.toString());
		
		linkedList.addObject("Jorge");
		System.out.println(linkedList.toString());
		
		linkedList.addObject("Cibils");
		System.out.println(linkedList.toString());
		
		linkedList.addObject("Casariego", 2);
		System.out.println(linkedList.toString());
		
		linkedList.remove(3);
		System.out.println(linkedList.toString());
		
		System.out.println(linkedList.getIndex(1).toString());
		
	}
}
