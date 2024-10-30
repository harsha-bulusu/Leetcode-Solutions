class Solution {

    private int[] findLongestIncreasingSubsequence(int[] nums, int n) {
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        return lis;
    }

    private int[] findLongestDecreasingSubsequence(int[] nums, int n) {
        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }

        return lds;
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = findLongestIncreasingSubsequence(nums, n);
        int[] lds = findLongestDecreasingSubsequence(nums, n);

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1)
            minRemovals = Math.min(minRemovals, n - lis[i] - lds[i] + 1);
        }

        return minRemovals;
    }
}
