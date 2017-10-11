
/**
 * A binary tree node has data, pointer to left child
 * and a pointer to right child
 */
class Node {
	int data;
	Node left, right;
	
	public Node(int item) {
		data = item;
		left = right = null;
	}
	
}
	
public class BinaryTree {
	Node root;
	
	/*
	 * Given a binary tree, print out all of its root-to-leaf paths,
	 * one per line. Uses a recursive helper to do the work.
	 */
	void printPaths(Node node){
		int path[] = new int[1000];
		printPathRecursive(node, path, 0);
	}

	/*
	 * Recursive helper function: given a node, and an array containing the path from
	 * the root node up to but no  including this node, print out all the root-leaft-paths
	 */
	private void printPathRecursive(Node node, int[] path, int pathLength) {
		if(node == null){
			return;
		}
		
		// Append this node to the path array
		path[pathLength] = node.data;
		pathLength++;
		
		// It's a leaf, so print the path that led to here
		if(node.left == null && node.right == null) {
			printArray(path, pathLength);
		} else {
			// Otherwise  try both subtrees
			printPathRecursive(node.left, path, pathLength);
			printPathRecursive(node.right, path, pathLength);
		}
	}

	private void printArray(int[] path, int pathLength) {
		int i;
		for(i = 0; i<pathLength; i++){
			System.out.print(path[i] + " ");
		}
		System.out.println("");
	}
	
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		
		tree.root.right.left = new Node(2);
		
		tree.printPaths(tree.root);

	}
}
