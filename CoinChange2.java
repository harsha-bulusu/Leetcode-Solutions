class Solution {

    /**
        * Memoization
     */
    int count(int index, int amount, int[] coins, int[][] dp) {
        //Base case
        if (index == 0) {
            if (amount % coins[index] == 0) return 1;
            return 0;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        //operations
        int notTake = count(index - 1, amount, coins, dp);
        int take = 0;
        if (coins[index] <= amount)
            take = count(index, amount - coins[index], coins, dp);

        return dp[index][amount] = take + notTake;
    }

    /**
        * Tabulation
    */
    int count2(int amount, int[] coins, int n) {
        // int dp[][] = new int[n][amount + 1];
        int prev[] = new int[amount + 1];

        //Base condition
        for (int i = 0; i <= amount; i++)
            // if (i % coins[0] == 0) dp[0][i] = 1;
            if (i % coins[0] == 0) prev[i] = 1;
        
        //Representing states
        for (int cidx = 1; cidx < n; cidx++) { //cidx - coin index
            int curr[] = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {
                //operations
                // int notPick = dp[cidx - 1][amt];
                int notPick = prev[amt];
                int pick = 0;
                if (coins[cidx] <= amt)
                    // pick = dp[cidx][amt - coins[cidx]];
                    pick = curr[amt - coins[cidx]];
                // dp[cidx][amt] = pick + notPick;
                curr[amt] = pick + notPick;
            }
            prev = curr;
        }

        // return dp[n - 1][amount];
        return prev[amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int dp[][] = new int[n][amount + 1];
        // for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);
        // return count(n - 1, amount, coins, dp);
        return count2(amount, coins, n);
    }
}
