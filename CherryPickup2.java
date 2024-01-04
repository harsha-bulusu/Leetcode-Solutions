class Solution {

    int collect(int i, int j1, int j2, int[][] grid, int n, int m, int dp[][][]) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return -(int)10e7;
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int value = 0;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += collect(i + 1, j1 + di, j2 + dj, grid, n, m, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return collect(0, 0, m - 1, grid, n, m, dp);
    }
}
