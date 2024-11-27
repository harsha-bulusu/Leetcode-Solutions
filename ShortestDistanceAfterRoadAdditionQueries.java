class Solution {

    class Pair {
        int node;
        int length;

        Pair(int node, int length) {
            this.node = node;
            this.length = length;
        }
    }

    private int findShortestPathLength(List<List<Integer>> adjList, int[] query, int n) {
        adjList.get(query[0]).add(query[1]);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1, p2) -> p1.length - p2.length);
        priorityQueue.add(new Pair(0, 0));
        boolean[] visited = new boolean[n];

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.remove();
            int node = pair.node;
            int length = pair.length;

            if (node == n - 1) return length; 

            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    priorityQueue.add(new Pair(adj, length + 1));
                }
            }
        }

        return 0;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            List<Integer> adjElements = new ArrayList<>();
            adjElements.add(i + 1);
            adjList.add(adjElements);
        }
        adjList.add(new ArrayList<>());

        int answers[] = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            answers[i++] = findShortestPathLength(adjList, query, n);
        }

        return answers;
    }
}
