class Solution {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int []edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int adj : adjList.get(i)) {
                indegree[adj]++;
            }
        }

        int cnt = 0;
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                cnt++;
                if (cnt > 1) return -1;
                champion = i;
            }
        }

        return champion;
    }
}
