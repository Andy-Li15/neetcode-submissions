class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                count--;
            }
        }
        return count;
    }
}

class UnionFind {
    // parent[i] is parent of i, -1 if no parent
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        Arrays.fill(parent, -1);
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (rank[rootB] > rank[rootA]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        rank[rootA] += rank[rootB];
        return true;
    }

    public int find(int a) {
        if (parent[a] == -1) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}
