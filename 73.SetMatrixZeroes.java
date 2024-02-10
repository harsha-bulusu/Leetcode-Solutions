class Solution {
    public void setZeroes(int[][] matrix) {
        // Brute force : O(n * m) + O(n * m) Doesn't work in the case of negative numbers
        //     int m = matrix.length;
        //     int n = matrix[0].length;

        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (matrix[i][j] == 0) {
        //                 for (int k = 0; k < n; k++) {
        //                     if (matrix[i][k] != 0)
        //                         matrix[i][k] = -1;
        //                 }
        //                 for (int k = 0; k < m; k++) {
        //                     if (matrix[k][j] != 0)
        //                         matrix[k][j] = -1;
        //                 }
        //             }
        //         }
        //     }

        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (matrix[i][j] == -1) {
        //                 matrix[i][j] = 0;
        //             }
        //         }
        //     }
        // }

        // Better : Using reference arrays for storing references of row and columns which are to be transformed
        // TC : O(n ^ m) + O(n ^ m), SC : O(n) + O(m)
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int col[] = new int[n];
        // int row[] = new int[m];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 0) {
        //             row[i] = 1;
        //             col[j] = 1;
        //         }
        //     }
        // }

        // for (int i = 0; i < m; i++) {
        //     if (row[i] == 1) {
        //         for (int j = 0; j < n; j++) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     if (col[i] == 1) {
        //         for (int j = 0; j < m; j++) {
        //             matrix[j][i] = 0;
        //         }
        //     }
        // }

        // Optimal
        int m = matrix.length;
        int n = matrix[0].length;
        // 1 row acts as column reference
        // 1st col acts as row reference
        //. Traverse and mark references
        int col0 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // update row reference
                    matrix[i][0] = 0;
                    // update col reference 
                    if (j != 0)
                        matrix[0][j] = 0;
                    else 
                        col0 = 0;
                }
            }
        }

        // traverse indexes which are not used as references
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // checking first row
        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        // checking first column
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
