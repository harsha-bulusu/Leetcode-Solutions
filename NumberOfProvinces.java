class Solution {

    void bfs(int startNode, boolean[] vis, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            vis[node] = true;

            for (int adjNode : adjList.get(node)) {
                if (!vis[adjNode])
                    queue.add(adjNode);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        // convert given adjmatrix to adjList
        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i + 1).add(j + 1);
                }
            }
        }

        System.out.println(adjList);

        boolean[] vis = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                count++;
                bfs(i, vis, adjList);
            }
        }
        return count;

    }
}
