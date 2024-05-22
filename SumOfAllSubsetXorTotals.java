class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < Math.pow(2, n); i++) {
            int xor = 0;
            for (int j = 0; j < n; j++) {
                if ((1 << j & i) > 0) {
                    xor ^= nums[j];
                }
            }
            sum += xor;
        }
        return sum;
    }
}
