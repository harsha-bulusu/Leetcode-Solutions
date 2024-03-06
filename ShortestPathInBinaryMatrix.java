class Data {
    int row;
    int col;
    int dist;

    public Data(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Data> queue = new LinkedList<>();

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n - 1 == 0 && grid[0][0] == 0) return 1;
        else if (n - 1 == 0) return 0;

        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 1;

        queue.add(new Data(0, 0, 1));
        while (!queue.isEmpty()) {
            Data data = queue.remove();
            int row = data.row;
            int col = data.col;
            int distance = data.dist;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nextRow = row + i;
                    int nextCol = col + j;
                    int newDistance = distance + 1;
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0 && dist[nextRow][nextCol] > newDistance) {
                        if (nextRow == n - 1 && nextCol == n - 1) {
                            return newDistance;
                        }
                        dist[nextRow][nextCol] = newDistance;
                        queue.add(new Data(nextRow, nextCol, newDistance));
                    }
                }
            }
        }

        return -1;
    }
}
