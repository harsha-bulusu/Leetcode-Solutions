class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        // define search space
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            // check for a sorted array
            // checking left sub array is sorted???
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // nums[mid] <= nums[high]
            // With Binary search property: Atleast one sub array is sorted
                if (nums[mid] <= nums[high]) {
                    if (nums[mid] <= target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
