class Solution {

    /**
        * Memoization
    */
    //represent states 
    int f(int i, int j, String s1, String s2, int[][] dp) {
        //base case
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        //operations
        if (s1.charAt(i) == s2.charAt(j)) return 1 + f(i - 1, j - 1, s1, s2, dp);
        return dp[i][j] = Math.max(f(i - 1, j, s1, s2, dp), f(i, j -1, s1, s2, dp));
    }

    int tabulate(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // int dp[][] = new int[m + 1][n + 1];
        int prev[] = new int[n + 1];

        //Base case (loading negative indexes i.e., -1 with 0) **Considering String indexing from 1 and 0 in DP signifies -1 index
        // for (int i = 0; i <= m; i++) {
        //     dp[i][0] = 0;
        // }
        // for (int j = 1; j <= n; j++) {
        //     dp[0][j] = 0;
        // }

        for (int j = 0; j <= n; j++) {
           prev[j] = 0;
        }

        //represent states
        for (int i = 1; i <= m; i++) {
            int curr[] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                //operate
                int val = 0;
                // if (s1.charAt(i - 1) == s2.charAt(j - 1)) val = 1 + dp[i -1][j - 1];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) val = 1 + prev[j - 1];
                // else val = Math.max(dp[i -1][j], dp[i][j - 1]); 
                else val = Math.max(prev[j], curr[j - 1]); 
                // dp[i][j] = val;
                curr[j] = val;
            }
            prev = curr;
        }
        // return dp[m][n];
        return prev[n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // int m = text1.length();
        // int n = text2.length();
        // int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++)
        //     Arrays.fill(dp[i], -1);

        // return f(m - 1, n - 1, text1, text2, dp);
        return tabulate(text1, text2);
    }
}
