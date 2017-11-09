import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	public static class Node {
		int id;
		List<Node> next = new LinkedList<Node>();		// Adjacent nodes
		Node(int id){
			this.id = id;
		}
	}
	
	public static Node getNode(int id){
		return nodeLookup.get(id);
	}
	
	public static void addEdge(int source, int destination) {
		Node a = getNode(source);
		Node b = getNode(destination);
		a.next.add(b);
	}
	
	public static List<Node> shortestPath(Node a, Node b) {
		if(a == null || b == null) {
			return null;
		}
		
		Queue<Node> toVisit = new LinkedList<Node>();
		HashMap<Node, Node> parents = new HashMap<>();
		toVisit.add(a);
		parents.put(a, null);	// Parent of a will be null. It doesn't have parent
		
		while(!toVisit.isEmpty()) {
			Node current = toVisit.remove();
			if(current == b){
				break;
			}
			// We visit every child until get Node b
			for(Node n: current.next) {
				toVisit.add(n);
				parents.put(n, current);
			}
		}
		
		if(parents.get(b) == null) {
			return null;
		}
		
		// Reverse mode :D
		List<Node> out = new LinkedList<Node>();
		Node current = b;
		while(current != null) {
			out.add(0, current);
			current = parents.get(current);
		}
		
		return out;
	}
	
	/*
	 *     	1 --------- 2
	 * 		^ \		    |   
	 * 		|  --> 3 ---|
	 * 		| /			!
	 * 		4 <-------- 5
	 * 
	 */
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		nodeLookup.put(1, node1);
		
		Node node2 = new Node(2);
		nodeLookup.put(2, node2);
		
		Node node3 = new Node(3);
		nodeLookup.put(3, node3);
		
		Node node4 = new Node(4);
		nodeLookup.put(4, node4);
		
		Node node5 = new Node(5);
		nodeLookup.put(5, node5);
		
		addEdge(1, 2);
		addEdge(1, 3);
		addEdge(2, 5);
		addEdge(5, 4);
		addEdge(4, 3);
		addEdge(4, 1);
		
		List<Node> sPath = shortestPath(getNode(2), getNode(3));
		
		if(sPath != null){
			for(Node n: sPath) {
				System.out.print(n.id + " -> ");
			}

		}
				
		System.out.println("null");
	}
}
