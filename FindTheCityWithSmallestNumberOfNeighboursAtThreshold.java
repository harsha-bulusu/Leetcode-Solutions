class Pair {
    int city;
    int dist;

    public Pair(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }
}
class Solution {

    void findShortestPath(List<List<Pair>> adjList, int[] dis, int src) {
        Arrays.fill(dis, (int)1e9);
        dis[src] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int city = pair.city;
            int dist = pair.dist;

            // edge relaxation
            for (Pair adjPair : adjList.get(city)) {
                int adjCity = adjPair.city;
                int adjDist = adjPair.dist;

                if (dis[city] + adjDist < dis[adjCity]) {
                    dis[adjCity] = dis[city] + adjDist;
                    queue.add(new Pair(adjCity, dis[city] + adjDist));
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        int city = -1, minCitiesReachable = Integer.MAX_VALUE;

        // perform shortest path algorithm on every city
        for (int i = 0; i < n; i++) {
            int dis[] = new int[n];
            findShortestPath(adjList, dis, i);

            // count number of cities reachable
            int count = -1;
            for (int d : dis) {
                if (d <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCitiesReachable) {
                minCitiesReachable = count;
                city = Math.max(city, i);
            }
        }

        return city;
    }
}
