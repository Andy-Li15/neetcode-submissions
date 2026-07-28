/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
Idea: use hashmap to check if a node has already been copied
*/

class Solution {

    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        copyFrom(head, newHead);
        return newHead;

    }

    private void copyFrom(Node head, Node newHead) {
        if (newHead.next == null && head.next != null) {
            if (!map.containsKey(head.next)) {
                Node newNext = new Node(head.next.val);
                map.put(head.next, newNext);
                newHead.next = newNext;
                copyFrom(head.next, newHead.next);
            } else {
                newHead.next = map.get(head.next);
            }
        }
        if (newHead.random == null && head.random != null) {
            if (!map.containsKey(head.random)) {
                Node newRandom = new Node(head.random.val);
                map.put(head.random, newRandom);
                newHead.random = newRandom;
                copyFrom(head.random, newHead.random);
            } else {
                newHead.random = map.get(head.random);
            }
        }
    }
}
