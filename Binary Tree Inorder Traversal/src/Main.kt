import java.util.*
import kotlin.collections.ArrayList

/*

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1, 3, 2]


 */

class TreeNode(val valor: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(1)
    val right = TreeNode(2)
    val left = TreeNode(3)

    root.right = right
    root.right!!.left = left

    println("Result: ${inOrderTraversal(root).toString()}")

}

fun inOrderTraversal(root: TreeNode): ArrayList<Int?> {
    val stack = Stack<TreeNode>()
    var current: TreeNode? = root
    val list: ArrayList<Int?> = arrayListOf()

    while(current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        list.add(current?.valor)
        current = current?.right

    }

    return list

}
