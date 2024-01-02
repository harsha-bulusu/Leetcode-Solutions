class Solution {

    /**
        * Recursion + memoization
     */
    int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return (int)10e7;
        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + solve(i - 1, j, grid, dp);
        int left = grid[i][j] + solve(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int dp[][] = new int[m][n];

        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return solve(m - 1, n - 1, grid, dp);

        /**
            * Tabulation
         */
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == 0 && j == 0) {
        //             dp[i][j] = grid[i][j];
        //             continue;
        //         }
        //         int up = grid[i][j] + (int) 10e7;
        //         int left = grid[i][j] + (int) 10e7;
        //         if (i > 0) {
        //             up = grid[i][j] + dp[i - 1][j];
        //         } 
        //         if (j > 0) {
        //             left = grid[i][j] + dp[i][j - 1];
        //         }   
        //         dp[i][j] = Math.min(up, left);
        //     }
        // }

        // return dp[m - 1][n - 1];


        /**
            * Tabulation + Space optimization
         */
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j <n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                    continue;
                }

                int up = (int)10e7;
                int left = (int)10e7;

                if (i > 0) {
                    up = grid[i][j] + prev[j];
                }
                if (j > 0) {
                    left = grid[i][j] + curr[j - 1];
                }

                curr[j] = Math.min(up, left);
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}
