import kotlin.math.abs

/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
     return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    Constraints:
    - The number of nodes in each linked list is in the range [1, 100].
    - 0 <= Node.val <= 9
    - It is guaranteed that the list represents a number that does not have leading zeros.

 */
class ListNode(var variable: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val final = ListNode(0)
        var current: ListNode? = final
        var rest = 0
        var listNode1 = l1
        var listNode2 = l2

        while(listNode1 != null || listNode2 != null) {
            var value1 = 0
            var value2 = 0

            if (listNode1 != null) {
                value1 = listNode1.variable
            }

            if (listNode2 != null) {
                value2 = listNode2.variable
            }

            val result = value1 + value2 + rest

            current?.next = ListNode(result % 10)
            current = current?.next
            rest = abs(result / 10)

            listNode1 = listNode1?.next
            listNode2 = listNode2?.next

        }

        if (rest > 0) {
            current?.next = ListNode(rest)
        }

        return final.next
    }
}

fun main() {
    val solution = Solution()
    val l1 = ListNode(9)
    l1.next = ListNode(9)
    l1.next!!.next = ListNode(9)

    val l2 = ListNode(9)
    //l2.next = ListNode(6)
    //l2.next!!.next = ListNode(4)

    var result = solution.addTwoNumbers(l1, l2)

    while(result != null) {
       print(result.variable)
        result = result.next
    }
}
