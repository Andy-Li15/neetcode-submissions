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
store result in l1, result points to head
end stores last node before null
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = l1;
        ListNode end = l1;

        while (l1 != null && l2 != null) {
            l1.val += l2.val + carry;
            if (l1.val > 9) {
                l1.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            end = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            end.next = l2;
            l1 = l2;
        }

        while (l1 != null) {
            l1.val += carry;
            if (l1.val > 9) {
                l1.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            end = l1;
            l1 = l1.next;
        }

        if (carry == 1) {
            ListNode one = new ListNode(1);
            end.next = one;
        }

        return result;
    }
}
