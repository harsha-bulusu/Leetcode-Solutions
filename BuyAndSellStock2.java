class Solution {

    int solve(int index, int buy, int[] prices, int n, int[][] dp) {
        if (index == n) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        if (buy == 1) { // chances of buying stock on ith day
            int take = -prices[index] + solve(index + 1, 0, prices, n, dp);
            int notTake = 0 + solve(index + 1, 1, prices, n, dp);
            return dp[index][buy] = Math.max(take, notTake);
        }
        // chances of selling stock on ith day
        int take = prices[index] + solve (index + 1, 1, prices, n, dp); 
        int notTake = 0 + solve(index + 1, 0, prices, n, dp);
        return dp[index][buy] = Math.max(take, notTake);

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return solve(0, 1, prices, prices.length, dp);
    }
}
