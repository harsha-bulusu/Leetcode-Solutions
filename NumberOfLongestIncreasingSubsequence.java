class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if ((nums[i] > nums[prev]) && (dp[i] < dp[prev] + 1)) {
                    dp[i] = dp[prev] + 1;
                    cnt[i] = cnt[prev];
                } else if (nums[i] > nums[prev] && (dp[i] == dp[prev] + 1)) {
                    cnt[i] += cnt[prev];
                }
                max = Math.max(max, dp[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) count += cnt[i];
        }

        return count;
    }
}
