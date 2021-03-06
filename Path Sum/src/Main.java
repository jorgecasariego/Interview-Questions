import java.util.ArrayList;
import java.util.List;

/*
 
	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Given the below binary tree and sum = 22,
	
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \      \
	7    2      1
	
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
public class Main {
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		int sum = 22;
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(11);
			
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
	
		System.out.println("Result: " + hasPathSum(root, sum));
		
		System.out.println("all root-to-leaf paths where each path's sum equals : " + sum + " are: ");
		System.out.println(" " + pathSum(root, sum));
	}
	
	 public static boolean hasPathSum(TreeNode root, int sum) {
		 if(root == null) {
			 return false;
		 } else if(root.left == null && root.right == null && sum - root.val == 0) {
			 return true;
		 } else {
			 return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		 }
		 
	 }
	 
	 /**
	  	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

		Note: A leaf is a node with no children.
		
		Example:
		
		Given the below binary tree and sum = 22,
		
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1
		Return:
		
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
	  */
	 public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		 List<List<Integer>> paths = new ArrayList<>();
		 
		 findPaths(root, sum, new ArrayList<Integer>(), paths);
		 
		 return paths;
		 
	 }

	private static void findPaths(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> paths) {
		if (root == null) {
			return;
		}
		
		current.add(root.val);
		if (root.left == null && root.right == null && sum - root.val == 0) {
			paths.add(current);
		}
		
		
		findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), paths);
		findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), paths);
	}
}
