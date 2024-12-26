class Solution {

    int mod = (int)(1e9 + 7);
    private int helper(int currNum, long currSum, int n, int x, int[][] dp) {
        if (currSum == n) return 1;
        if (currSum > n || currNum > n) return 0;
        if (dp[currNum][(int)currSum] != -1) return dp[currNum][(int)currSum];

        long sum = (int)Math.pow(currNum, x);
        int add = helper(currNum + 1, currSum + sum, n, x, dp);
        int skip = helper(currNum + 1,currSum, n, x, dp);

        return dp[currNum][(int)currSum] = (add + skip) % mod;
    }

    public int numberOfWays(int n, int x) {
        int [][]dp = new int[n + 1][n + 1];
        for (int []row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(1, 0, n, x, dp);
    }
}
