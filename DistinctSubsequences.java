class Solution {

    /**
        * Memoization
     */
    int solve(int i, int j, String s, String t, int[][] dp) {
        //base-case
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        //operations
        if (s.charAt(i) == t.charAt(j)) {
            int pick = solve(i - 1, j - 1, s, t, dp); //pick on match
            int notPick = solve(i - 1, j, s, t, dp); //not pick on match
            return pick + notPick;
        } 
        return dp[i][j] = solve(i - 1, j, s, t, dp);
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++)
        //     Arrays.fill(dp[i], - 1);
        // return solve(m - 1, n - 1, s, t, dp);

        // tabulation - by considering 1 based indexing
        // int dp[][] = new int[m + 1][n + 1];

        // //base -case
        // for (int i = 0; i <= m; i++) dp[i][0] = 1;
        // for (int j = 1; j <= n; j++) dp[0][j] = 0;

        // //represent states
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         //operations
        //         if (s.charAt(i - 1) == t.charAt(j - 1)) {
        //             dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; //pick + notPick
        //         } else {
        //             dp[i][j] = dp[i - 1][j];
        //         }
        //     }
        // }
        // return dp[m][n];


        //optimizing space complexity in tabulation

        // int prev[] = new int[n + 1];

        // //base -case
        // prev[0] = 1;

        // //represent states
        // for (int i = 1; i <= m; i++) {
        //     int curr[] = new int[n + 1];
        //     curr[0] = 1;
        //     for (int j = 1; j <= n; j++) {
        //         //operations
        //         if (s.charAt(i - 1) == t.charAt(j - 1)) {
        //             curr[j] = prev[j - 1] + prev[j]; //pick + notPick
        //         } else {
        //             curr[j] = prev[j];
        //         }
        //     }
        //     prev = curr;
        // }
        // return prev[n];

        int dp[] = new int[n + 1];

        //base -case
        dp[0] = 1;

        //represent states
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                //operations
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j]; //pick + notPick
                }
            }
        }
        return dp[n];

    }
}
