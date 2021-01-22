
public class SolutionAdd2Numbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        //l2.next = ListNode(6)
        //l2.next!!.next = ListNode(4)

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalListNode = new ListNode(0);
        ListNode current = finalListNode;

        int result = 0;
        int rest = 0;

        while(l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;

            if (l1 != null) {
                value1 = l1.val;
            }

            if (l2 != null) {
                value2 = l2.val;
            }

            // L1 = 8 -> 7 > null
            // L2 = 3 -> 4 > null
            result = value1 + value2 + rest; // 7 + 4 + 1 = 12

            // val = 0
            // next > {val = 1, next > null}
            // val = 1
            // next > {val = 2, next > null}
            current.next = new ListNode(result % 10);
            current = current.next;
            rest = Math.abs(result/10); // 1

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (rest != 0) {
            current.next = new ListNode(rest);
        }

        return finalListNode.next;
    }
}
