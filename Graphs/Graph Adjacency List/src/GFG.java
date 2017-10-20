import java.util.LinkedList;

public class GFG {

	/*
	 * A graph is an array of adjacency lists.
	 * Size of array will be V (number of vertices
	 * in graph)
	 */
	public static class Graph {
		int v;
		LinkedList<Integer> adjListArray[];
		
		//Constructor
		public Graph(int v){
			this.v = v;
			
			// Define the size of the array as
			// number of vertices
			adjListArray = new LinkedList[v];
			
			// Create a new list for each vertex
			// such the adjacent nodes can be stored
			for(int i=0; i<v; i++){
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	public static void addEdge(Graph g, int src, int dest){
		// Add and edge from src to dest
		g.adjListArray[src].addFirst(dest);
		
		// Since graph is undirect, add an edge from dest
		g.adjListArray[dest].addFirst(src);
	}
	
	public static void printGraph(Graph g){
		for(int i=0; i<g.v; i++){
			System.out.println("Adjacency list of vertex " + i);
			System.out.println("head");
			for(Integer pCrawl: g.adjListArray[i]){
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		int v = 5;
		Graph graph = new Graph(v);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		
		printGraph(graph);
		
	}
}
