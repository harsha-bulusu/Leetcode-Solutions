class Solution {
    public int maxSubArray(int[] nums) {
        //Brute force : O(n*n) TLE
        // int max = Integer.MIN_VALUE;
        // int n = nums.length;
        // if (n == 1) return nums[0];
        // for (int i = 0; i < n; i++) {
        //     int sum = 0;
        //     for (int j = i; j < n; j++) {
        //         sum += nums[j];
        //         max = Math.max(sum, max);
        //     }
        // }
        // return max;

        // Optimal : Kadane algorithm
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
