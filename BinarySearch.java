class Solution {

    int binarySearch(int low, int high, int nums[], int target) {
        //Base condition
        if (low > high) return -1;

        //operations
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return binarySearch(mid + 1, high, nums, target);
        return binarySearch(low, mid - 1, nums, target);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        // Define your search space
        // int low = 0, high = n - 1;
        // while (low <= high) {
        //     int mid = (low + high) / 2;

        //     if (nums[mid] == target) {
        //         return mid;
        //     } 
        //     if (nums[mid] < target) {
        //         low = mid + 1;
        //     } else {
        //         high = mid - 1;
        //     }
        // }

        // return -1;
        return binarySearch(0, n - 1, nums, target);
    }
}
