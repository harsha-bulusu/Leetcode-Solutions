class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Creating an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(graph[i][j]).add(i);
            }
        }

        // Perform a topo sort on the reversed graph you will get all the nodes which are reachable from terminal node
        int v = adjList.size();
        int indegree[] = new int[v];

        for (int i = 0; i < v; i++) {
            for (int adjNode : adjList.get(i)) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            list.add(node);

            for (int adjNode : adjList.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
