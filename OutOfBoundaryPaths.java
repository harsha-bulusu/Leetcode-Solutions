class Solution {

    static int mod = (int)1e9 + 7;

    public int solve(int i, int j, int maxMove, int m, int n, int[][][] dp) {
        //base case
        if (i < 0 || j < 0 || i >= m || j>= n) return 1;
        if (dp[i][j][maxMove] != -1) return dp[i][j][maxMove];
        
        //operations
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        int moves = 0;
        for (int k = 0; k < delRow.length; k++) {
            if (maxMove > 0) {
                int nRow = i + delRow[k];
                int nCol = j + delCol[k];
                moves += solve(nRow, nCol, maxMove - 1, m , n, dp) % mod;
                moves %= mod;
            }
        }
        return dp[i][j][maxMove] = moves % mod;
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
