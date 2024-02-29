class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList.get(v).add(u);
        }

        // find indegree of all nodes
        int indegree[] = new int[numCourses];
        for (List<Integer> adjNodes : adjList) {
            for (int adjNode : adjNodes) {
                indegree[adjNode]++;
            }
        }

        // find nodes with indegree as 0

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            res.add(node);
            for (int adjNode : adjList.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }


        if (res.size() == numCourses) { 
            int order[] = new int[numCourses];
            for (int i = 0; i < res.size(); i++) {
                order[i] = res.get(i);
            }
            return order;
        }
        return new int[]{};
    }
}
