/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head; // node 1
        ListNode end = head; // node 1

        // set end to node (1 + n + 1)
        for (int i = 0; i <= n; i++) {
            if (end == null) return head.next;
            end = end.next;
        }

        while (end != null) {
            result = result.next;
            end = end.next;
        }
        result.next = result.next.next;

        return head;

    }

}
