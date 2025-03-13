class Solution {

    private boolean isTransformed(int[] nums, int[][] queries, int right) {
        int diff[] = new int[nums.length + 1];

        for (int i = 0; i < right; i++) {
            int l = queries[i][0], r = queries[i][1], v = queries[i][2];
            diff[l] += v;
            diff[r + 1] -= v;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diff[i];
            if (sum < nums[i]) return false;
        }

        return true;
    }


    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;
        if (!isTransformed(nums, queries, right)) return -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isTransformed(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
