class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findUltimateParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulpU = findUltimateParent(u);
        int ulpV = findUltimateParent(v);
        if (ulpU == ulpV) {
            return;
        }

        if (size[ulpU] < size[ulpV]) {
            parent[ulpU] = ulpV;
            size[ulpV] += size[ulpU];
        } else {
            parent[ulpV] = ulpU;
            size[ulpU] += size[ulpV];
        }
    }
}


class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraConnections = 0;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (ds.findUltimateParent(u) == ds.findUltimateParent(v)) {
                extraConnections++;
                continue;
            }

            ds.unionBySize(u, v);
        }

        int components = 0;
        for (int i = 0; i < ds.parent.length; i++) {
            if (i == ds.parent[i]) components++;
        }

        return extraConnections >= components - 1 ? components - 1 : -1;
    }
}
