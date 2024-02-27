class Solution {

    void dfs(int row, int col, char[][] grid, boolean[][] vis, int m, int n) {
        vis[row][col] = true;

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !vis[nRow][nCol] && grid[nRow][nCol] == '1') {
                dfs(nRow, nCol, grid, vis, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, vis, m, n);
                }
            }
        }

        return count;
    }
}
