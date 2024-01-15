class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i;  j < n; j++){
                product *= nums[j];
                max = Math.max(max, product);
            }
            product = 1;
        }
        return max;
    }
}
