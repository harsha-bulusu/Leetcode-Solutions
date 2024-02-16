class Solution {

    int max(int[] nums) {
        int max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 0, high = max(nums);
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            int sum = 0;
            for (int num : nums) {
                sum += Math.ceil((double)num / (double)mid);
            }

            if (sum <= threshold) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}
