class Solution {
    private int helper(int currNum, int sum, int m, int n, int[][] dp) {
        if (sum > n || currNum > m) return (int)1e9;
        if (sum == n) return 0;
        if (dp[currNum][sum] != -1) return dp[currNum][sum];

        int r1 = 1 + helper(currNum, sum + currNum * currNum, m, n, dp);
        int r2 = helper(currNum + 1, sum, m, n, dp);

        return dp[currNum][sum] = Math.min(r1, r2);
    }

    public int numSquares(int n) {
        int m = (int)Math.sqrt(n);
        int [][]dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(1, 0, m, n, dp);
    }
}
