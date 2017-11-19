import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
	
	// This is used to get a quick access to the node with the node id (Mapping Node_id --> node)
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	public static class Node {
		private int id;		//This represent the node id
		LinkedList<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id) {
			this.id = id;
		}
	}
	
	private Node getNode(int id) {
		return nodeLookup.get(id);
	}
	
	private void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		
		s.adjacent.add(d);
	}
	
	public boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		
		// In this HashSet I will record all the nodes that I already visited
		HashSet<Integer> visited = new HashSet<Integer>();		// This is the key!
		
		return hasPathDFS(s, d, visited);
	}
	
	// This method is to know if exist a path from source to destination using a DFS algorithm
	public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
		if(visited.contains(source.id)) {
			return false;
		}
		
		visited.add(source.id);
		if(source == destination) {
			return true;
		}
		
		for(Node child: source.adjacent) {
			if(hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasPathBFS(int source, int destination) {
		return hasPathBFS(getNode(source), getNode(destination));
	}
	
	// This method is to know if exist a path from source 
	// to destination using a BFS algorithm
	private boolean hasPathBFS(Node source, Node destination) {

		// This is the key!
		LinkedList<Node> nextToVisit = new LinkedList<Node>();	
		HashSet<Integer> visited = new HashSet<Integer>();
		
		// In BFS algorithm we begin the search by the source node
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()){
			// We remove this node and add the childs to the node to visit
			Node node = nextToVisit.remove();
			if(node == destination) {
				return true;
			}
			
			// Just continue and then get the next value
			if(visited.contains(source.id)){
				continue;
			}
			visited.add(node.id);
			
			for(Node child: node.adjacent) {
				nextToVisit.add(child);
			}
		}
		
		return false;
		
	}

}
