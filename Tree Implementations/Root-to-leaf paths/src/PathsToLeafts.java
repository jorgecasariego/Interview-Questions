import java.util.ArrayList;
import java.util.Iterator;

public class PathsToLeafts {
	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value){
			this.value = value;
		}
		
	}
	
	
	public static void printRootToLeaftPaths(TreeNode root){
		ArrayList<Integer> path = new ArrayList<Integer>();
		pathToLeaft(root, path);
	}
	
	//				1
	//			   / \
	//	  		  2	  3
	// 		     / \
	//			4	5
	//
	// node = 1 - 2 - 4
	// Result: [1, 2, 4], remove 4 --> [1,2,5]
	public static void pathToLeaft(TreeNode node, ArrayList<Integer> path){
		path.add(node.value);
		
		if(node.left == null && node.right == null){
			printResult(path);
		}
		
		if(node.left != null){
			pathToLeaft(node.left, path);
		}
		
		if(node.right != null){
			pathToLeaft(node.right, path);
		}
		
		path.remove(path.size()-1);
	}
	
	public static void printResult(ArrayList<Integer> result){
		Iterator<Integer> i = result.iterator();
		System.out.print("[");
		while(i.hasNext()){
			System.out.print(i.next() + ",");
		}
		System.out.println("]");
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		printRootToLeaftPaths(root);
	}
}
