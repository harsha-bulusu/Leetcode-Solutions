class Solution {
    public int searchInsert(int[] nums, int target) {
        //Binary Search
        int n = nums.length;
        int low = 0, high = n - 1; // defining the search space
        int index = n;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
