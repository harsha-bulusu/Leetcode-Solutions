class Solution {

    /**
        * Recursion + Memoization
     */
    int f(List<List<Integer>> triangle, int i, int j, int n, int[][] dp) {
        if (i == n) return triangle.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + f(triangle, i + 1, j, n, dp);
        int diagonal = triangle.get(i).get(j) + f(triangle, i + 1, j + 1, n, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int dp[][] = new int[m][n];

        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return f(triangle, 0, 0, n - 1, dp);

        /**
            * Tabulation
         */

        // for (int i = 0; i < n; i++) {
        //     dp[m - 1][i] = triangle.get(m - 1).get(i);
        // }

        // for (int i = m - 2; i >= 0; i--) {
        //     for (int j = i; j >= 0; j--) {
        //         int down = triangle.get(i).get(j) + dp[i + 1][j];
        //         int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
        //         dp[i][j] = Math.min(down, diagonal);
        //     }
        // }

        // return dp[0][0];

        /**
            * Tabulation + Space optimization
         */

         int base[] = new int[n];
         for (int i = 0; i < n; i++) {
             base[i] = triangle.get(m - 1).get(i);
         }

         for (int i = m - 2; i >= 0; i--) {
             int curr[] = new int[i + 1];
             for (int j = i; j >= 0; j--) {
                 int down = triangle.get(i).get(j) + base[j];
                 int diagonal = triangle.get(i).get(j) + base[j + 1];
                 curr[j] = Math.min(down, diagonal);
             }
             base = curr;
         }
         return base[0];
        
    }
}
