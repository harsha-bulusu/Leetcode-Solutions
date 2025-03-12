class Solution {

    private int findFirstPositive(int[] nums, int n) {
        int low = 0;
        int high = n - 1;

        int res = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > 0) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res; 
    }

    private int findLastNegative(int[] nums, int n) {
        int low = 0;
        int high = n - 1;

        int res = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= 0) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }

        return res - 1;
    }


    // private int binarySearch(int[] nums, int n, Predicate<Integer> predicate) {
    //     int low = 0;
    //     int high = n - 1;

    //     int res = n;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (predicate.test(nums[mid])) {
    //             high = mid - 1;
    //             res = mid;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return res;
    // }

    public int maximumCount(int[] nums) {
        // upperbound
        int n = nums.length;
        int firstPositiveIndex = findFirstPositive(nums, n);
        int lastNegativeIndex = findLastNegative(nums, n);

        // int firstPositiveIndex = binarySearch(nums, n, num -> num > 0);
        // int lastNegativeIndex = binarySearch(nums, n, num -> num >= 0) - 1;
        
        int totalNegatives = lastNegativeIndex >= 0 ? lastNegativeIndex + 1 : lastNegativeIndex;
        int totalPositives = firstPositiveIndex == n ? 0 : (n - firstPositiveIndex);

        return totalPositives > totalNegatives ? totalPositives : totalNegatives;
    }
}
