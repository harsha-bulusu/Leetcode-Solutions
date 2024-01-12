class Solution {

    /**
        * Memoization
     */
    int count(int index, int amount, int coins[], int[][] dp) {
        //base condition
        if (index == 0) {
            if (amount % coins[index] == 0) return amount / coins[index];
            return (int)1e9;
        }
        if (dp[index][amount] != -1) return dp[index][amount];

        //operate
        int notPick = 0 + count(index - 1, amount, coins, dp);
        int pick = (int)1e9;
        if (amount >= coins[index])
            pick = 1 + count(index, amount - coins[index], coins, dp);
        
        return dp[index][amount] = Math.min(pick, notPick);
    }

    /**
        * Tabulation
    */

    int count2(int[] coins, int amount, int n) {
        // int dp[][] = new int[n][amount + 1];
        int prev[] = new int[amount + 1];

        //Base condition
        for (int i = 0; i <= amount; i++) {
            // if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            // else dp[0][i] = (int)1e9;
            if (i % coins[0] == 0) prev[i] = i / coins[0];
            else prev[i] = (int)1e9;
        }

        //Represent states
        for (int index = 1; index < n; index++) {
            int curr[] = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {
                //operate
                // int notPick = 0 + dp[index - 1][amt];
                int notPick = prev[amt];
                int pick = (int)1e9;
                if (amt >= coins[index])
                    // pick = 1 + dp[index][amt - coins[index]];
                    pick = 1 + curr[amt - coins[index]];
                // dp[index][amt] = Math.min(pick, notPick);
                curr[amt] = Math.min(pick, notPick);
            }
            prev = curr;
        }

        // return dp[n - 1][amount];
        return prev[amount];
    }
    

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);
        // int res = count(n - 1, amount, coins, dp);
        int res = count2(coins, amount, n);
        if (res == (int)1e9) return -1;
        return res;
    }
}
