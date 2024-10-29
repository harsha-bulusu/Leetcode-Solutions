class Solution {

    private int dfs(int row, int col, int[][] grid, boolean[][] vis, int[][] dp) {
        if (dp[row][col] != -1) return dp[row][col];
        
        int delRow[] = {0, -1, 0, 1};
        int delCol[] = {-1, 0, 1, 0};

        int fishes = grid[row][col];
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + delRow[i];
            int nextCol = col + delCol[i];

            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length 
                && grid[nextRow][nextCol] != 0 && !vis[nextRow][nextCol]) {
                fishes += dfs(nextRow, nextCol, grid, vis, dp);
            }
        }

        return dp[row][col] = fishes;
    }

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;
        int dp[][] = new int[m][n];
        for (int []row : dp) Arrays.fill(row, -1);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    boolean[][] vis = new boolean[m][n];
                    max = Math.max(dfs(i, j, grid, vis, dp), max);
                }
            }
        }

        return max;
    }
}
