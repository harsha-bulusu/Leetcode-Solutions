class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                // element exists in this range
                int lb = 0, ub = n - 1;
                while (lb <= ub) {
                    int md = (lb + ub) / 2;
                    if (matrix[mid][md] == target) return true;
                    if (matrix[mid][md] > target) ub = md - 1;
                    else lb = md + 1;
                }
            }
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
