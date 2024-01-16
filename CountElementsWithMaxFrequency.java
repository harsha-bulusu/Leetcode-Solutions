class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        int maxFreq = -1;
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
            maxFreq = Math.max(maxFreq, freq[nums[i]]);
        }

        int res = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                res += maxFreq;
            }
        }
        return res;
    }
}
