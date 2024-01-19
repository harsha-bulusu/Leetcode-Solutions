class Solution {

    int f(int i, int j, int m, int[][] matrix, int[][] dp) {
        //Base case
        if (j < 0 || j > m) return (int)1e9;
        if (i == m) return matrix[i][j];
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        //operations
        int min = (int)1e9;
        for (int k = -1; k <= 1; k++) {
            min = Math.min(min, f(i + 1, j + k, m, matrix, dp));
        }
        return dp[i][j] = min + matrix[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int dp[][] = new int[m][m];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        /**
            Why DP is initialized with min value? If the input array has an element which leads to the dp value -1 it will lead to unlimited computations
         */
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(f(0, i, m - 1, matrix, dp), min);
        }

        return min;
    }
}
