class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int firstRowFactor = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowFactor = 0;
                    } else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        
        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < n; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < m; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }

            
        }

        if (firstRowFactor == 0) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }

        
    }
}
