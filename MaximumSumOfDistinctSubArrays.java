class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        int n = nums.length;
        long sum = 0;
        long maxSum = 0;
        Set<Integer> set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l += 1;
            }

            set.add(nums[r]);
            sum += nums[r];

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }
        }


        return maxSum;
    }
}
