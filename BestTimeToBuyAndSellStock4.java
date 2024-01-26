class Solution {

    /**
        * Memoization
     */
    int solve(int day, int buy, int cap, int[] prices, int[][][] dp) {
        if (day == prices.length || cap == 0) return 0;
        if (dp[day][buy][cap] != -1) return dp[day][buy][cap];
        if (buy == 1) {
            return dp[day][buy][cap] = Math.max(-prices[day] + solve(day + 1, 0, cap, prices, dp), solve(day + 1, 1, cap, prices, dp));
        } else {
            return dp[day][buy][cap] = Math.max(prices[day] + solve(day + 1, 1, cap - 1, prices, dp), solve(day + 1, 0, cap, prices, dp));
        }
    }

    /**
        * Tabulation
     */
    int solveT(int []prices, int n, int k) {
        // int dp[][][] = new int[n + 1][2][k + 1];
        int after[][] = new int[2][k + 1];

        //represent states
        for (int day = n - 1; day >= 0; day--) {
            int curr[][] = new int[2][k + 1];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        // dp[day][buy][cap] = Math.max(-prices[day] + dp[day + 1][0][cap], dp[day + 1][1][cap]);
                        curr[buy][cap] = Math.max(-prices[day] + after[0][cap], after[1][cap]);
                    } else {
                        // dp[day][buy][cap] = Math.max(prices[day] + dp[day + 1][1][cap - 1], dp[day + 1][0][cap]);
                        curr[buy][cap] = Math.max(prices[day] + after[1][cap - 1], after[0][cap]);
                    }
                }
            }
            after = curr;
        }

        // return dp[0][1][k];
        return after[1][k];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int [][][]dp = new int[n][2][k + 1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return solve(0, 1, k, prices, dp);
        return solveT(prices, n, k);
    }
}
