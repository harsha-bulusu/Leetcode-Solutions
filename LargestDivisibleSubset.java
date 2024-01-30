class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; // for LIS counts
        Arrays.fill(dp, 1);
        int[] hash = new int[n]; // for subset path
        for (int i = 0; i < n; i++) hash[i] = i;

        for (int i = 1; i < n; i++) {
            for (int prev = i - 1; prev >= 0; prev--) {
                if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
        }

        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {   
            if (dp[i] > maxValue) {
                maxValue = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        int i = maxIndex;
        while (hash[i] != i) {
            res.add(nums[i]);
            i = hash[i];
        }
        res.add(nums[i]);

        return res;
    }
}
