class Solution {
    public int longestConsecutive(int[] nums) {
        //Brute force : Linear search TC: O(n ^ 2)
        //Better : Sort TC : O(nlogn) + O(n) SC : O(1)
        // int n = nums.length;
        // if (n == 0) return 0;
        // Arrays.sort(nums);
        // int maxCount = 0;
        // int count = 1;
        // int prev = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] - 1 == prev) {
        //         count++;
        //     } else if (nums[i] != prev) {
        //         count = 1;
        //     }
        //     maxCount = Math.max(maxCount, count);
        //     prev = nums[i];
        // }
        // return maxCount;

        //Optimal : Hashing
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int maxCount = 1;
        for (int num : set) {
            if (set.contains(num - 1)) continue;
            int count = 1;
            int temp = num;
            while (set.contains(temp + 1)) {
                count++;
                temp++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
