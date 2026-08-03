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

    HashMap<Integer, Node> indexToNode;
    HashSet<Node> cloned;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        indexToNode = new HashMap<>();
        cloned = new HashSet<>();
        Node root = clone(node);
        return root;
    }

    private Node clone(Node node) {
        // create or get clone of current node
        Node cur = indexToNode.computeIfAbsent(node.val, (val) -> new Node(val));

        // create neighboring nodes if not yet created
        if (!cloned.contains(cur)) {
            cloned.add(cur);
            for (Node neighbor : node.neighbors) {
                cur.neighbors.add(clone(neighbor));
            }
        }
        return cur;
    }
}






