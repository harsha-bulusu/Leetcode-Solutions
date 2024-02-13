class Solution {

    // number itself or immediate greater element
    int lowerBoundary(int[] nums, int x, int n) {
        int idx = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

    // immediate greater element
    int upperBoundary(int[] nums, int x, int n) {
        int idx = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

    int findFirstOccurrance(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                idx = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else { // nums[mid] < target
                low = mid + 1;
            }
         }

        return idx;
    }

    int findLastOccurrance(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                idx = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else { // nums[mid] < target
                low = mid + 1;
            }
         }

        return idx;
    }




    public int[] searchRange(int[] nums, int target) {
        // Approach - 1: Find lower and upper boundaries {lb, ub - 1}
        // int n = nums.length;
        // int lb = lowerBoundary(nums, target, n);
        // if (lb == n || nums[lb] != target) return new int[]{-1, -1};
        // int ub = upperBoundary(nums, target, n);
        // return new int[]{lb, ub - 1};

        // Approach - 2: Finding first and last occurrances by 2 binary search operations
        int fo = findFirstOccurrance(nums, target);
        if (fo == -1) return new int[]{-1, -1};
        int so = findLastOccurrance(nums, target);
        return new int[]{fo, so};
    }
}
