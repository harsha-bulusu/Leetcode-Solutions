class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList.get(v).add(u);
        }

        // find the indegree of all nodes
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int adjNode : adjList.get(i)) {
                indegree[adjNode]++;
            }
        }


        // find nodes with 0 indegree i.e., independent nodes
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) return false;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            cnt++;
            for (int adjNode : adjList.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }

        // if queue is empty that means all the courses can be completed else no
        return cnt == numCourses;
    }
}
