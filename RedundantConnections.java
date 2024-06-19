class Solution {

    int parent[];
    int rank[];
    
    int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    boolean findUnion(int u, int v) {
        int u_parent = findParent(u);
        int v_parent = findParent(v);

        if (u_parent == v_parent) return false;

        if (rank[u_parent] < rank[u_parent]) {
            parent[u_parent] = v_parent;
        } else if (rank[v_parent] < rank[u_parent]) {
            parent[v_parent] = u_parent;
        } else {
            parent[u_parent] = v_parent;
            rank[v_parent]++;
        }

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        Arrays.fill(rank, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (findUnion(u, v) == false) {
                return new int[]{u, v};
            }
        }

        return new int[]{};
    }
}
