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
Merge 2 lists at a time
Let half = lists.length / 2
    half(6) = 3 and half(5) = 2
    merge 2 lists, half times
The distance between 2 lists should be (lists.length + 1) / 2
    dist(6) = 3 and dist(5) = 3
Merge 0 with 0 + dist, then 1 with 1 + dist, and so on
Remaining length of lists to be merged is equal to dist
    6 lists -> 3 lists, 5 lists -> 3 lists

*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        while (length > 1) {
            int half = length / 2;
            length = (length + 1) / 2;
            for (int i = 0; i < half; i++)
                lists[i] = merge2Lists(lists[i], lists[i + length]);
        }
        return lists[0];
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // add nodes to dummy while both lists are not null
        while ((list1 != null) && (list2 != null)) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        // add remaining nodes of list1
        while (list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }
        // add remaining nodes of list2
        while (list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}







