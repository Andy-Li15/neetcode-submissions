/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Node, Node> nodeMap;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        nodeMap = new HashMap<>();
        return clone(node);
    }

    private Node clone(Node node) {
        // create or get clone of current node
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node copy = new Node(node.val);
        nodeMap.put(node, copy);
        // create neighboring nodes
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor));
        }
        return copy;
    }
}






