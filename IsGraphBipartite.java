class Solution {

    boolean colorNodes(int node, List<List<Integer>> adjList, int[] color, int nodeColor) {
        color[node] = nodeColor;

        for (int adjNode : adjList.get(node)) {
            int nextColor = 1 - nodeColor;
            if (color[adjNode] == -1) {
                if (!colorNodes(adjNode, adjList, color, nextColor)) return false;          
            }
            if (color[adjNode] == nodeColor) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        //generate an adjacency matrix
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        int color[] = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!colorNodes(i, adjList, color, 0)) return false;
            }
        }

        return true;
    }
}
