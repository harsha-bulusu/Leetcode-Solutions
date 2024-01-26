class Solution {

    int f(int day, int buy, int[] prices, int fee, int[][] dp) {
        if (day == prices.length) return 0;
        if (dp[day][buy] != -1) return dp[day][buy];

        if (buy == 1) return dp[day][buy] = Math.max(-prices[day] + f(day + 1, 0, prices, fee, dp), f(day + 1, 1, prices, fee, dp));
        return dp[day][buy] = Math.max((prices[day] - fee) + f(day + 1, 1, prices, fee, dp), f(day + 1, 0, prices, fee, dp));
    }

    int t(int[] prices, int n, int fee) {
        // int [][]dp = new int[n + 1][2];

        // for (int day = n - 1; day >= 0; day--) {
        //     for (int buy = 0; buy < 2; buy++) {
        //         //operations
        //         if (buy == 1) dp[day][buy] = Math.max(-prices[day] + dp[day + 1][0], dp[day + 1][1]);
        //         else dp[day][buy] = Math.max(prices[day] - fee + dp[day + 1][1], dp[day + 1][0]);
        //     }
        // }
        // return dp[0][1];


        int []after = new int[2];

        for (int day = n - 1; day >= 0; day--) {
            int curr[] = new int[2];
            curr[1] = Math.max(-prices[day] + after[0], after[1]);
            curr[0] = Math.max(prices[day] - fee + after[1], after[0]);
            after = curr;
        }
        return after[1];
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int[][] dp = new int[n][2];
        // for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return f(0, 1, prices, fee, dp);
        return t(prices, n, fee);
    }
}
