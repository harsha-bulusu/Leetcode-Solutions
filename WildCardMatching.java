class Solution {

    /**
        * Memoization
     */
    boolean solve(int i, int j, String s, String p, int[][] dp) {
        //base case
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (j >= 0 && i < 0) {
            for (int ind = 0; ind <= j; ind++) {
                if (p.charAt(ind) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

        //operations
        boolean res = false;
        if (s.charAt(i) == p.charAt(j)) {
            res = solve(i - 1, j - 1, s, p, dp);
            dp[i][j] = res ? 1 : 0;
        }
        if (p.charAt(j) == '?') {
            res = solve(i - 1, j - 1, s, p, dp);
            dp[i][j] = res ? 1 : 0;
        }
        if (p.charAt(j) == '*') {
            res = solve(i - 1, j, s, p, dp) || solve(i, j - 1, s, p, dp);
            dp[i][j] = res ? 1 : 0;
        }
        dp[i][j] = 0;
        return res; // if characters doesn't match
    } 

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // int [][]dp = new int[m][n];
        // for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        // return solve(m - 1, n - 1, s, p, dp);

        // Tabulation
        // boolean [][]dp = new boolean[m + 1][n + 1];
        boolean []prev = new boolean[n + 1];

        //base case
        
        // dp[0][0] = true;
        // for (int i = 1; i <= m; i++) {
        //     dp[i][0] = false;
        // }
        // for (int j = 1; j <= n; j++) {
        //     boolean flag = true;
        //     for (int k = 0; k < j; k++) {
        //         if (p.charAt(k) != '*') {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     dp[0][j] = flag;
        // }

        // base case
        prev[0] = true;

        for (boolean i : prev) {
            System.out.print(i + " ");
        }
        System.out.println();

        // represent states
        for (int i = 1; i <= m; i++) {
            boolean curr[] = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                boolean flag = true;
                for (int k = 0; k < j; k++) {
                    if (p.charAt(k) != '*') {
                        flag = false;
                        break;
                    }
                }
                curr[0] = flag;
            }

            for (boolean v : curr) {
                System.out.print(v + " ");
            }
            System.out.println();

            for (int j = 1; j <= n; j++) {
                //operations
                // if (s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                // else if (p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                // else if (p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                // else dp[i][j] = false;
                if (s.charAt(i - 1) == p.charAt(j - 1)) curr[j] = prev[j - 1];
                else if (p.charAt(j - 1) == '?') curr[j] = prev[j - 1];
                else if (p.charAt(j - 1) == '*') curr[j] = prev[j] || curr[j - 1];
                else curr[j] = false;
            }
            prev = curr;
        }
        // return dp[m][n];
        return prev[n];
    }
}
