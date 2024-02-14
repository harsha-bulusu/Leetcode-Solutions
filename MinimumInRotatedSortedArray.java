class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        // define your search space
        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            // search for minimum in a sorted array
            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else { // arr[mid] <= arr[high] -> searching in right sub-array
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
