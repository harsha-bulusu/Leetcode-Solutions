class Solution {

    private int dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        int maxHeight = 0;
        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                int height = dfs(adjNode, adj, vis);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        return 1 + maxHeight;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // find height of all the trees
        // store min height in a variable
        // maintain a dictionary to store all the roots according to the heights
        // Map<Integer, List<Integer>> for storing heights

        // Prepare adjacency list with given edges

        if (n == 1) return Arrays.asList(0);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int indegree[] = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indegree[i] = adj.get(i).size();
            
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }

        while (!leaves.isEmpty()) {
            if (n <= 2) {
                return new ArrayList<>(leaves);
            }

            int len = leaves.size();
            for (int i = 0; i < len; i++) {
                int node = leaves.remove();
                n--;
                for (int adjNode : adj.get(node)) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 1) {
                        leaves.add(adjNode);
                    }
                }
            }
        }

        return new ArrayList<>();


        /**
            * Brute force: Using BFS/DFS (considering every node as start node)
         */
        // int minHeight = Integer.MAX_VALUE;
        // Map<Integer, List<Integer>> heightMap = new HashMap<>();

        // for (int i = 0; i < n; i++) {
        //     boolean[] vis = new boolean[n];
        //     int height = dfs(i, adj, vis);
        //     minHeight = Math.min(height, minHeight);
        //     List<Integer> heights = heightMap.getOrDefault(height, new ArrayList<>());
        //     heights.add(i);
        //     heightMap.put(height, heights);
        // }

        // return heightMap.get(minHeight);




    }
}
