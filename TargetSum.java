class Solution {

    /**
        * Memoization
    */
    int count(int index, int target, int[] nums, int dp[][]) {
        //base case
        if (index == 0) {
            if (nums[0] == 0 && target == 0) return 2;
            if (target == 0 || nums[0] == target) return 1;
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];

        //operate
        int notPick = count(index - 1, target, nums, dp);
        int pick = 0;
        if (nums[index] <= target)
            pick = count(index - 1, target - nums[index], nums, dp);
        
        return dp[index][target] = pick + notPick;
    }

    /**
        * Tabulation
     */
    
    int count2(int nums[], int n, int target) {
        // int dp[][] = new int[n][target + 1];
        int prev[] = new int[target + 1];

        //base-case
        // if (nums[0] == 0) dp[0][0] = 2;
        // else dp[0][0] = 1;

        // if (nums[0] != 0 && nums[0] <= target)
        //     dp[0][nums[0]] = 1;

        if (nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (nums[0] != 0 && nums[0] <= target)
            prev[nums[0]] = 1;

        // expressing states
        for (int index = 1; index < n; index++) {
            int curr[] = new int[target + 1];
            for (int k = 0; k <= target; k++) {
                //operate
                // int notTake = dp[index - 1][k];
                int notTake = prev[k];
                int take = 0;
                if (nums[index] <= k)
                    // take = dp[index - 1][k - nums[index]];
                    take = prev[k - nums[index]];
                // dp[index][k] = take + notTake;
                curr[k] = take + notTake;
            }
            prev = curr;
        }
        // return dp[n - 1][target];
        return prev[target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        /**
            * Intution : Assuming two subsets s1 (positive integers) and s2 (negative integers)
            s1 + s2 = totalsum (ts) -> (1)
            s1 - s2 = target -> (2)
            substituting expr (1) in (2)
            (totalsum - s2) - s2 = target;
            totalsum - target = 2S2
            s2 = (totalsum - target) / 2
            count subsets with target as s2
         */
         int n = nums.length;
         int totalSum = Arrays.stream(nums).sum();
         int del = (totalSum - target);
         if (del < 0 || del %2 != 0) return 0;
         int s2 = del / 2;
        //  int[][] dp = new int[n][s2 + 1];
        //  for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);
        //  return count(n - 1, s2, nums, dp);
        return count2(nums, n, s2);
    }
}
