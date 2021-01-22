import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearch {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Integer prev;


    /**
     *          5
     *         /\
     *        1  4
     *          /\
     *         3  6
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean isValid = isValidBST(root);

        System.out.println("Is Valid " + isValid);

        boolean isValid2 = inOrder(root);

        System.out.println("Is Valid using inOrder: " + isValid2);

        boolean isValid3 = inOrder(root);

        System.out.println("Is Valid using inOrder with Stack: " + isValid3);
    }

    /**
     * Approach 1: Code Walkthrough
     *
     * Time complexity : O(N) since we visit each node exactly once.
     * Space complexity : O(N) since we keep up to the entire tree.
     */
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    /**
     * In every step I need to check that root.val is between left and right
     * @param root
     * @param left
     * @param right
     * @return
     */
    private static boolean validate(TreeNode root, Integer left, Integer right) {
        if (root == null)
            return true;

        if (left != null && left >= root.val || right != null && right <= root.val) {
            return false;
        }

        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
    }

    /**
     * Approach 2
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        prev = null;
        return validate(root, null, null);
    }

    /**
     * Approach 2: In Order traversal
     * @param root
     *
     */
    private static boolean inOrder(TreeNode root) {
        if (root == null) return true;
        if(!inOrder(root.left)) return false;   // If this return false means that the root's left subtree is not a valid BST
        if (prev != null && root.val <= prev) return false;

        prev = root.val;
        return inOrder(root.right);
    }

    /**
     * Approach 2: In Order traversal using Stack
     * @param root
     *
     */
    private static boolean inOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double lowerValue = - Double.MIN_VALUE;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(lowerValue >= root.val) return false;
            lowerValue = root.val;
            root = root.right;
        }

        return true;
    }
}
