class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += nums[j];

            while (i <= j && sum > target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            }

            if (sum == target) {
                min = Math.min(min, j - i + 1);
            }
            j++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
