class Solution {

    int[][] longestCommonSubsequence(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        //base-case
        /**
            * the indexes are represented from 1 and index 0 implies -1 i.e., out of boundary case which holds 0 value
        */

        // represent states
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp;
    }


    public String shortestCommonSupersequence(String str1, String str2) {
        // The shortest common supersequence is formed by combining string 1 and 2 where the common characters are included only once
        /**
            The length of the shortest common supersequence will be len(s1) + len(s2) - longestcommonsubsequence(s1, s2)
         */

        int m = str1.length();
        int n = str2.length();
        int[][] dp = longestCommonSubsequence(str1, str2, m, n);
        // printing shortest common super sequence
        String res = "";
        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                res += str1.charAt(m - 1);
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1]) {
                res += str1.charAt(m - 1);
                m--;
            } else {
                res += str2.charAt(n - 1);
                n--;
            }
        }

        while (m > 0) {
            res += str1.charAt(m - 1);
            m--;
        }

        while (n > 0) {
            res += str2.charAt(n - 1);
            n--;
        }

        return new StringBuilder(res).reverse().toString();
    }
}
