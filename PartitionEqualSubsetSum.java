class Solution {

    boolean subSetSumEqualsK(int[] nums, int index, int target, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return nums[index] == target;
        if (dp[index][target] != -1) return dp[index][target] == 1 ? true : false;

        boolean take = false;
        if (target >= nums[index])
            take = subSetSumEqualsK(nums, index - 1, target - nums[index], dp);
        boolean notTake = subSetSumEqualsK(nums, index - 1, target, dp);

        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        int n = nums.length;
        // int[][] dp = new int[n][target + 1];
        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return subSetSumEqualsK(nums, n - 1, target, dp);

        // boolean[][] dp = new boolean[n][target + 1];
        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = true;
        // }

        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (nums[0] <= target)
            prev[nums[0]] = true;
        // if (nums[0] <= target)
        //     dp[0][nums[0]] = true;

        for (int index = 1; index < n; index++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int k = 1; k <= target; k++) {
                boolean take = false;
                if (nums[index] <= k)
                    // take = dp[index - 1][k - nums[index]]; 
                    take = prev[k - nums[index]];
                // boolean notTake = dp[index - 1][k];
                // dp[index][k] = take || notTake;
                boolean notTake = prev[k];
                curr[k] = take || notTake;
            }
            prev = curr;
        }

        // return dp[n - 1][target];
        return prev[target];
    }
}
