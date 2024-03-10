class Solution {

    int subarrayWithAtmostK(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        while (r < n) {
            int num = nums[r];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.size() > k) {
                int tar = nums[l];
                int updatedFreq = map.get(tar) - 1;
                if (updatedFreq == 0) map.remove(tar);
                else map.put(tar, updatedFreq);
                l++;
            }

            if (map.size() <= k) {
                count += r - l + 1;
            }
            r++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // generate number of sub arrays with at most k and k - 1 ==> subarr(k) - subarr(k - 1)
        return subarrayWithAtmostK(nums, k) - subarrayWithAtmostK(nums, k - 1);
    }
}
