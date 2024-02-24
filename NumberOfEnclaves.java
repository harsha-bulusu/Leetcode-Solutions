class Pair {
    int row;
    int col;

    public Pair (int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                queue.add(new Pair(i, 0));
                vis[i][0] = true;
            }

            if (grid[i][n - 1] == 1) {
                queue.add(new Pair(i, n - 1));
                vis[i][n - 1] = true;
            }
        }

        for (int j = 1; j < n- 1; j++) {
            if (grid[0][j] == 1) {
                queue.add(new Pair(0, j));
                vis[0][j] = true;
            }

            if (grid[m - 1][j] == 1) {
                queue.add(new Pair(m - 1, j));
                vis[m - 1][j] = true;
            }
        }

        while (!queue.isEmpty()) {
            Pair cell = queue.remove();
            int row = cell.row;
            int col = cell.col;

            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, - 1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nextRow = row + delRow[i];
                int nextCol = col + delCol[i];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !vis[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
                    vis[nextRow][nextCol] = true;
                    queue.add(new Pair(nextRow, nextCol));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
