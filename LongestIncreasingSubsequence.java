class Solution {

    /**
        * Memoization
     */
    int solve(int index, int prevIndex, int n, int nums[], int dp[][]) {
        //base case
        if (index == n) return 0;
        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        //operations
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) 
            take = 1 + solve(index + 1, index, n, nums, dp);
        int notTake = 0 + solve(index + 1, prevIndex, n, nums, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        // int dp[][] = new int[n][n + 1];
        // for (int arr[] : dp) Arrays.fill(arr, -1);
        // return solve(0, -1, n, nums, dp);

        //tabulation
        // int dp[][] = new int[n + 1][n + 1]; // columns will be from -1 to n, and rows will be 0 to n and n + 1 for out of boundary
        int after[] = new int[n + 1];


        //represent states
        for (int i = n - 1; i >= 0; i--) {
            int curr[] = new int[n + 1];
            for (int prev = i - 1; prev >= -1; prev--) {
                // int notTake = 0 + dp[i + 1][prev + 1];
                int notTake = 0 + after[prev + 1];
                int take = 0;
                // if (prev == -1 || nums[i] > nums[prev]) take = 1 + dp[i + 1][i + 1];
                // dp[i][prev + 1] = Math.max(take, notTake);
                if (prev == -1 || nums[i] > nums[prev]) take = 1 + after[i + 1];
                curr[prev + 1] = Math.max(take, notTake);
            }
            after = curr;
        }

        // return dp[0][0];
        return after[0];

    }

    public int lengthOfLIS(int[] nums) {
        //optimized approach
        int n = nums.length;
        int maxLength = 1;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int prev = i - 1; prev >= 0; prev--) {
                if (nums[i] > nums[prev])
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    maxLength = Math.max(dp[i], maxLength);
            }
        } 

        return maxLength;
    }
}
