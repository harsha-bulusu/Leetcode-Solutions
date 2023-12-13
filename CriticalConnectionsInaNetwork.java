class Solution {

    private int timer = 1;

    private void dfs(int node, int parent, List<List<Integer>> adj, int[] low, int[] tin, boolean[] vis, List<List<Integer>> bridges) {
        vis[node] = true;
        low[node] = timer;
        tin[node] = timer;
        timer++;

        for (Integer adjNode : adj.get(node)) {
            if (adjNode == parent) continue;

            if (!vis[adjNode]) {
                dfs(adjNode, node, adj, low, tin, vis, bridges);
                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] > tin[node]) {
                    bridges.add(Arrays.asList(node, adjNode));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] vis = new boolean[n];
        int[] low = new int[n]; // lowest node through which a node can be reachable
        int[] tin = new int[n]; //time of insertion

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, adj, low, tin, vis, bridges);

        return bridges;
    }
}
