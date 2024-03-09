class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, swap = 0;
        int n = nums.length;
        int maxLen = 0;

        while (j < n) {
            if (nums[j] == 0) swap++;

            while (swap > k) {
                if (nums[i] == 0) swap--;
                i++;
            }
            
            if (swap <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
        }

        return maxLen;
    }
}
