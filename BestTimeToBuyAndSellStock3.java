class Solution {

    /**
        * Memoization with 3D DP
     */
    int solve(int day, int buy, int cap, int[] prices, int[][][] dp) {
        //base case
        if (day == prices.length || cap == 0) return 0;
        if (dp[day][buy][cap] != -1) return dp[day][buy][cap];
        //operation
        if (buy == 1) { // chance for buying
            return dp[day][buy][cap] = Math.max(
                -prices[day] + solve(day + 1, 0, cap, prices, dp), 
                solve(day + 1, 1, cap, prices, dp)
            ); // max (buy, notBuy) on current day
        }
        // chance for selling
        return dp[day][buy][cap] = Math.max(
            prices[day] + solve(day + 1, 1, cap - 1, prices, dp),
            solve(day + 1, 0, cap, prices, dp)
        ); // max(sell, notSell) on current day
    }

    /**
        * Tabulation
     */
    int solveT(int[] prices, int n) {
        // int dp[][][] = new int[n + 1][2][3];
        int after[][] = new int[2][3];
        //base case - ignoring framing as default value of int is 0 (which is the target to set for base cases)

        //represent states
        for (int day = n - 1; day >= 0; day--) {
            int curr[][] =  new int[2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    //operations
                    if (buy == 1) { // chances for buying
                        // dp[day][buy][cap] = Math.max(-prices[day] + dp[day + 1][0][cap], dp[day + 1][1][cap]);
                        curr[buy][cap] = Math.max(-prices[day] + after[0][cap], after[1][cap]);
                    } else { // chances for selling
                        // dp[day][buy][cap] = Math.max(prices[day] + dp[day + 1][1][cap - 1], dp[day + 1][0][cap]);
                        curr[buy][cap] = Math.max(prices[day] + after[1][cap - 1], after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        // return dp[0][1][2];
        return after[1][2];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n][2][3]; // price * buy/not-buy * 0/1/2 cap 
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return solve(0, 1, 2, prices, dp);
        return solveT(prices, n);
    }
}
