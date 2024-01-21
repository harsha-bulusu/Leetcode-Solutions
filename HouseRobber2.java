class Solution {

    /**
        Memoization
     */
    int solve(int index, int lastHouseIndex, int[] nums, int[] dp) {
        if (index == lastHouseIndex) return nums[index];
        if (dp[index] != -1) return dp[index];
        int notPick = 0 + solve(index - 1, lastHouseIndex, nums, dp);
        int pick = nums[index];
        if (index > lastHouseIndex + 1)
            pick += solve(index - 2, lastHouseIndex, nums, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    /**
        * Tabulate
     */
    int tabulate(int[] nums, int startIndex, int n) {
        // int dp[] = new int[nums.length];
        //base case
        // dp[startIndex] = nums[startIndex];
        int prev = nums[startIndex];
        int prev2 = 0;
        //represent states
        for (int i = startIndex + 1; i < n; i++) {
            //operate
            // int notPick = 0 + dp[i - 1];
            int notPick = 0 + prev;
            int pick = nums[i];
            if (i > startIndex + 1)
                // pick += dp[i - 2];
                pick += prev2;
            
            // dp[i] = Math.max(pick, notPick);
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        // return dp[n - 1];
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // int f1 = solve(n - 2, 0, nums, dp);
        // Arrays.fill(dp, -1);
        // int f2 = solve(n - 1, 1, nums, dp);
        // return Math.max(f1, f2);
        return Math.max(tabulate(nums, 0, n - 1), tabulate(nums, 1, n));
    }
}
