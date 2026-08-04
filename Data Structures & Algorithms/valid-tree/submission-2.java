/*
tree has no cycles
tree had n - 1 edges

use bfs where node cannot be connected to any previous node except parent
*/
class Solution {
    private record Pair(int node, int parent) {}
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        // add nodes to adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // start from node 0 and use bfs
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();

        queue.add(new Pair(0, -1));
        seen.add(0);

        while (!queue.isEmpty()) {
            // for each node in level, check if seen, then add to seen 
            // add adjacent nodes to queue while also removing parent from the adjacent node's list
            Pair cur = queue.remove();

            // add adjacent nodes to queue
            List<Integer> adj = adjList.get(cur.node());
            for (int node : adj) {
                if (node == cur.parent()) {
                    continue;
                }
                if (seen.contains(node)) {
                    return false;
                } 
                seen.add(node);
                queue.add(new Pair(node, cur.node()));
            }
        }
        return seen.size() == n;
    }
}
