class Solution {
    public int majorityElement(int[] nums) {
        // Brute force : Linear search O(n ^ 2) SC : O(1)
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (nums[i] == nums[j]) count++;
        //     }
        //     if (count > n / 2) return nums[i];
        // }
        // return -1;

        // Better solution : Hashing
        // TC : O(nlogn) + O(n), SC: O(n)
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i : nums) {
        //     map.put(i, map.getOrDefault(i, 0) + 1);
        // }

        // int max = -1;
        // int maxCount = 0;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int key = entry.getKey();
        //     int count = entry.getValue();
        //     if (count >  maxCount) {
        //         max = key;
        //         maxCount = count;
        //     }
        // }
        // return max;

        //Optimal : Moores voting algorithm
        int count = 0;
        int ele = 0;
        for (int i : nums) {
            if (count == 0) {
                ele = i;
                count++;
            }
            else if (i == ele) count++;
            else count--;
        }
        return ele;
    }
}
