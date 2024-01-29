class Solution {

    int solve(int index, int[] cost, int[] dp) {
        //base-case
        if (index == 0 || index == 1) return cost[index];
        if (dp[index] != -1) return dp[index];
        //operations
        return dp[index] = cost[index] + Math.min(solve(index - 1, cost, dp), solve(index - 2, cost, dp));
    }

    int solveT(int[] cost, int n) {
        int dp[] = new int[n];

        //base case
        dp[0] = cost[0];
        if (n > 1)
            dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    int solveT2(int[] cost, int n) {
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return Math.min(solve(n - 1, cost, dp), solve(n - 2, cost, dp));
        // return solveT(cost, n);
        return solveT2(cost, n);

    }
}
