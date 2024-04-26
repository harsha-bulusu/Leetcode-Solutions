class Solution {

    int findMinPath(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0) return grid[0][col];
        if (dp[row][col] != -1) return dp[row][col];

        int minPath = Integer.MAX_VALUE;
        for (int j = 0; j < grid.length; j++) {
            if (j != col) {
                minPath = Math.min(minPath, findMinPath(row - 1, j, grid, dp));
            }
        }
        return dp[row][col] = grid[row][col] + minPath;
    }

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        
        int minPath = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int j = 0; j < n; j++) {
            minPath = Math.min(minPath, findMinPath(n - 1, j, grid, dp));
        }
        return minPath;
    }
}
