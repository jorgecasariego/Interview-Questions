import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
 
 
 */
public class Main {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		
		root.left = null;
		root.right = right;
		root.right.left = left;
		
		System.out.println("Result: " + postorderTraversal(root).toString());
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		
		// For this problem I'll use an ArrayList to save the values and a Stack to save the root
		List<Integer> values = new ArrayList<Integer>();
		if(root == null) {
			return values;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			values.add(0, current.val);
			
			if(current.left != null) {
				stack.add(current.left);
			}
			
			if(current.right != null) {
				stack.add(current.right);
			}
		}
		
		return values;
		
	}
}
