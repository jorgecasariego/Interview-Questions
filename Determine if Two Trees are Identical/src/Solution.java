/*
 	Solution
 	********
 	sameTree(tree1, tree2)	
	1. If both trees are empty then return 1.
	2. Else If both trees are non -empty
	     (a) Check data of the root nodes (tree1->data ==  tree2->data)
	     (b) Check left subtrees recursively  i.e., call sameTree( 
	          tree1->left_subtree, tree2->left_subtree)
	     (c) Check right subtrees recursively  i.e., call sameTree( 
	          tree1->right_subtree, tree2->right_subtree)
	     (d) If a,b and c are true then return 1.
	3  Else return 0 (one is empty and other is not)
	
	Time Complexity: 
	***************
	Complexity of the identicalTree() will be according to the tree with 
	lesser number of nodes. Let number of nodes in two trees be m and n then 
	complexity of sameTree() is O(m) where m < n.
 */
public class Solution {

	// 1. First create a binary tree Node
	static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	// 2. Create a Binary Tree. This will have 2 roots (trees) and we have to compare both
	static class BinaryTree {
		Node root1, root2;
		
		// Given two trees, return true if they are structurally identical
		static boolean identical(Node a, Node b) {
			
			// Base case: If both are empty then true
			if(a == null && b == null){
				return true;
			}
			
			// If this trees are not empty we compare
			if(a != null && b != null) {
				return a.data == b.data && identical(a.left, b.left) && identical(a.right, b.right);
			}
			
			return false;
		}
		
		public static void main(String[] args){
			BinaryTree tree = new BinaryTree();
			
			tree.root1 = new Node(1);
			tree.root1.left = new Node(2);
			tree.root1.right = new Node(3);
			tree.root1.left.left = new Node(4);
			tree.root1.left.right = new Node(5);
			
			tree.root2 = new Node(1);
			tree.root2.left = new Node(2);
			tree.root2.right = new Node(6);
			tree.root2.left.left = new Node(4);
			tree.root2.left.right = new Node(5);
			
			if(identical(tree.root1, tree.root2)) {
				System.out.println("Both trees are identical");
			} else {
				System.out.println("Both trees are not identical");
			}
			
		}
		
	}
}
