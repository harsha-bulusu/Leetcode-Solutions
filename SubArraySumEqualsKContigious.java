class Solution {
    public int subarraySum(int[] nums, int k) {
        // Brute force TC : O(n ^ 2), SC: O(1)
        // int count = 0;
        // for (int i = 0; i < nums.length; i++){
        //     int sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         if (sum == k) count++;
        //     }
        // }
        // return count;

        // Optimal Approach : Hashing - Prefix sum
        Map<Integer, Integer> prefixSum = new HashMap<>(); // for storing sum, count
        prefixSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int diff = sum - k;
            count += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    } 
}
