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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode start = head; // node 1
        ListNode end = head; // node k
        ListNode next; // node after end

        boolean firstReverse = true;

        while (end != null) {
            // check if at least k nodes left
            for (int i = 0; i < (k - 1) && end != null; i++) {
                end = end.next;
            } 
            if (end == null) return head;
            next = end.next;

            // update head if it is first reverse
            if (firstReverse) {
                firstReverse = false;
                head = end;
            }
            
            reverseK(start, k);

            // reconnect reversed nodes
            if (prev != null) {
                prev.next = end;
            }
            prev = start;
            prev.next = next;
            
            // move to next set of nodes
            start = next;
            end = next;
        }
        return head;
    }

    // return new head after reverse
    private ListNode reverseK(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
