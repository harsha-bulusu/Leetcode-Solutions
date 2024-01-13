class Solution {

    /**
        * Memoization
     */
    int f(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + f(i - 1, j - 1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(f(i - 1, j, s1, s2, dp), f(i, j - 1, s1, s2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);
        return f(m, n, text1, text2, dp);
    }
}
