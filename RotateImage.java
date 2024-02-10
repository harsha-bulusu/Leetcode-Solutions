class Solution {

    void reverse(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Brute force : TC: O(n ^ 2) + O(n ^ 2) SC: O(n ^ 2)
        // int[][] tMatrix = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         tMatrix[j][n - i - 1] = matrix[i][j];
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         matrix[i][j] = tMatrix[i][j];
        //     }
        // }

        // Optimal approach : Transpose and revese rows
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }
}
