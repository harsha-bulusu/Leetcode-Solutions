class Solution {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 1, high = nums[n - 1];

        // finding a right x value.
        while (low <= high) {
            int x = (low + high) / 2;

            //Find lower bound
            int l = 0, h = n - 1;
            int idx = 0;
            while (l <= h) {
                int m = (l + h) / 2;
                if (nums[m] >= x) {
                    h = m - 1;
                    idx = m;
                } else {
                    l = m + 1;
                }
            }

            //find number of elements greater than or equal to x
            int numberOfElements = n - idx;
            if (numberOfElements == x) return x;
            if (numberOfElements > x) low = x + 1;
            else high = x - 1;
        }

        // if no valid x is found
        return -1;
    }
}
