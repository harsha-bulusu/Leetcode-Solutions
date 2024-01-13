class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;
        double prevSum = 0;
        
        for (int i = 0; i < k; i++) {
            prevSum += nums[i];
        }
        double maxAvg = prevSum / k;
        for (int i = 1; i <= n - k; i++) {
            double newSum = prevSum - nums[i - 1] + nums[i + k - 1];
            maxAvg = Math.max(maxAvg, (newSum / k));
            prevSum = newSum;
        }
        return maxAvg;
    }
}
