class Solution {

    /**
        * Memoization
     */
    int solve(int i, int j, String s1, String s2, int[][] dp) {
        //Base case - Either of the strings can exhaust
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];
        //operation
        if (s1.charAt(i) == s2.charAt(j)) {
            return 0 + solve(i - 1, j - 1, s1, s2, dp); // 0 -> No operation required on match, proceed to next index
        }
        int replace = solve(i - 1, j - 1, s1, s2, dp); // if replaced the chars match, move both pointers to next index
        int insert = solve(i, j - 1, s1, s2, dp); // inserting new character makes a match so j pointer gets decremented and i stays the same     assuming it has been decreased from newly inserted character
        int delete = solve(i - 1, j, s1, s2, dp); // deleting a character decrements i pointer

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace)); // 1 -> an operation is performed
    }

    

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // int[][] dp = new int[m + 1][n + 1];
        // for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        // return solve(m - 1, n - 1, word1, word2, dp);

        /**
            * Tabulation
        */

        //base case
        // for (int i = 0; i <= m; i++) dp[i][0] = i;
        // for (int j = 0; j <= n; j++) dp[0][j] = j;

        int prev[] = new int[n + 1];
        for (int j = 0; j <= n; j++) prev[j] = j;

        // represent states
        for (int i = 1; i <= m; i++) {
            int curr[] = new int[n + 1];
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                //operations
                // if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 0 + dp[i - 1][j - 1];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) curr[j] = 0 + prev[j - 1];
                else {
                    // int insert = dp[i][j - 1];
                    // int delete = dp[i - 1][j];
                    // int replace = dp[i - 1][j - 1];
                    int insert = curr[j - 1];
                    int delete = prev[j];
                    int replace = prev[j - 1];
                    // dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        // return dp[m][n];
        return prev[n];
    }
}
