class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findUltimateParent(int node) {
        if (parent[node] == node) return node;

        return findUltimateParent(parent[node]);
    }

    void unionBySize(int u, int v) {
        int ulpU = findUltimateParent(u);
        int ulpV = findUltimateParent(v);

        if (ulpU == ulpV) return;

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
    public int removeStones(int[][] stones) {
        // Find the coordinates of the 2D plane
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            ds.unionBySize(row, col);
            set.add(row);
            set.add(col);
        }
        

        int cnt = 0;
        for (int stone : set) {
            if (ds.findUltimateParent(stone) == stone) cnt++;
        }

        return stones.length - cnt;
    }
}
