class Solution {

    int helper(int index, int[] nums, int k, Map<Integer, Integer> freqMap) {
        if (index == nums.length) {
            return 1;
        }

        // take if there is no conflict
        int res = 0;
        if ((freqMap.get(nums[index] - k) == null || freqMap.get(nums[index] - k) == 0) 
        && (freqMap.get(nums[index] + k) == null || freqMap.get(nums[index] + k) == 0)) {
            freqMap.put(nums[index], freqMap.getOrDefault(nums[index], 0) + 1);
            res += helper(index + 1, nums, k, freqMap);
            freqMap.put(nums[index], freqMap.getOrDefault(nums[index], 1) - 1);
        }
        // not take
        res += helper(index + 1, nums, k, freqMap);
        return res;
    }

    public int beautifulSubsets(int[] nums, int k) {
        return helper(0, nums, k, new HashMap<>()) - 1;
    }
}
