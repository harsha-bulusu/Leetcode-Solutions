class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int operations = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int rem = k - nums[i];
            if (map.containsKey(rem) && map.containsKey(nums[i])) {
                if (nums[i] ==  rem && map.get(rem) == 1) continue;
                operations++;
                int remFreq = map.get(rem) - 1;
                if (remFreq == 0) {
                    map.remove(rem);
                } else {
                    map.put(rem, remFreq);
                }

                int numFreq = map.get(nums[i]) - 1;
                if (numFreq == 0) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], numFreq);
                }
            }
        }

        return operations;
    }
}
