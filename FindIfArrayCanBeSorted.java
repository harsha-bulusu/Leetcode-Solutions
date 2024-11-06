class Solution {

    private int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }

    // private boolean isSwappable(int num1, int num2) {
    //     return countSetBits(num1) == countSetBits(num2);
    // }

    // private void swap(int i, int j, int[] nums) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int j = i;
        //     while (j > 0 && nums[j - 1] > nums[j]) {
        //         if (!isSwappable(nums[j - 1], nums[j])) return false;
        //         swap(j - 1, j, nums);
        //         j--;
        //     }
        // }

        // return true;

        int prevMax = 0;
        int currMax = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < n; i++) {
            if (countSetBits(nums[i]) == countSetBits(currMax)) {
                // same segment
                currMax = Math.max(currMax, nums[i]);
                currMin = Math.min(currMin, nums[i]);
            } else {
                // different segment
                prevMax = currMax;
                currMax = nums[i];
                currMin = nums[i];
            }

            if (currMin < prevMax) return false;
        }

        return true;
    }
}
