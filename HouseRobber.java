class Solution {

    int solve(int index, int nums[], int dp[]) {
        if (index == 0) return nums[0];
        if (dp[index] != -1) return dp[index];
        int take = nums[index];
        if (index > 1) take += solve(index - 2, nums, dp);
        int notTake = 0 + solve(index - 1, nums, dp);

        return dp[index] = Math.max(take, notTake);
    }

    int tabulate(int []nums, int n) {
        // int dp[] = new int[n];

        // base-case
        // dp[0] = nums[0];
        int prev = nums[0];
        int prev2 = 0;

        //represent states
        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1)
                // take += dp[i - 2];
                take += prev2;
            // int notTake = 0 + dp[i - 1];
            int notTake = 0 + prev;

            // dp[i] = Math.max(take, notTake);
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        // return dp[n - 1];
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // return solve(n - 1, nums, dp);
        return tabulate(nums, n);
    }
}
