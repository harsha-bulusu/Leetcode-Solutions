class Solution {

    /** Memoization */
    int f(int i, int[] dp) {
        if (i == 0) return 1;
        if (dp[i] != -1) return dp[i];
        int os = f(i - 1, dp);
        int ts = 0;
        if (i > 1)
            ts = f(i - 2, dp);

        return dp[i] = os + ts;
    }

    /**
        * Tabulate
     */
    int f1(int n) {
        int dp[] = new int[n + 1];
        //base case
        // dp[0] = 1;
        int prev1 = 0;
        int prev2 = 1;

        //represent states
        for (int i = 1; i <= n; i++) {
            //operate
            int os = prev2; // dp[i - 1]
            int ts = 0;
            if (i > 1) ts = prev1; // dp[i - 2]
            int curr = os + ts;
            prev1 = prev2;
            prev2 = curr;
            //dp[i] = os + ts;
        }
        //return dp[n]
        return prev2;
    }

    public int climbStairs(int n) {
        // int []dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return f(n, dp);

        return f1(n);
    }
}
