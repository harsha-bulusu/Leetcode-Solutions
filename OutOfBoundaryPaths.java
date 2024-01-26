class Solution {

    static int mod = (int)1e9 + 7;

    public int solve(int i, int j, int maxMove, int m, int n, int[][][] dp) {
        //base case
        if (i < 0 || j < 0 || i >= m || j>= n) return 1;
        if (maxMove == 0) return 0;
        if (dp[i][j][maxMove] != -1) return dp[i][j][maxMove];
        
        //operations
        int up = solve(i - 1, j, maxMove - 1, m, n, dp) % mod;
        int down = solve(i + 1, j, maxMove - 1, m, n, dp) % mod;
        int left = solve(i, j - 1, maxMove - 1, m, n, dp) % mod;
        int right = solve(i, j + 1, maxMove - 1, m, n, dp) % mod;

        System.out.println(up + " " + left + " " + down + " " + right);
        return dp[i][j][maxMove] = ((up + left) % mod + (down + right) % mod) % mod;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(startRow, startColumn, maxMove, m, n, dp);
    }
}
