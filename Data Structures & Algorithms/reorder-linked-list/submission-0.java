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

/*
Use fast and slow pointer to find middle node
    for 5/6 nodes, middle node is 3

Reverse nodes after middle node
Merge first half and second half
*/

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find middle node
        ListNode slow = head; // node 1
        ListNode fast = head.next; // node 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reorder list
        // by combining first half with reversed second half
        ListNode first = head;
        ListNode second = reverse(slow.next);
        slow.next = null;
        
        while (first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}

