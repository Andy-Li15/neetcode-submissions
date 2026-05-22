/*
Idea: use node as stack, implement basic stack operations
For min, use another stack
    if new min found (or no min before), add to min stack
    pop if min is removed
*/
class MinStack {

    private Node stack;
    private Node minStack;
    private int min;

    public MinStack() {
        stack = new Node(0, null);
        minStack = new Node(0, null);
    }
    
    public void push(int val) {
        Node node = new Node(val, stack.next);
        stack.next = node;

        if (minStack.next == null || val <= getMin()) {
            node = new Node(val, minStack.next);
            minStack.next = node;            
        }
    }
    
    public void pop() {
        if (stack.next == null) return;
        int popped = top();
        stack.pop();
        if (popped == getMin()) minStack.pop();
    }
    
    public int top() {
        return stack.next.data;
    }
    
    public int getMin() {
        return minStack.next.data;        
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        void pop() {
            next = next.next;
        }
    }
}
