class Solution {

    public void rotate(int[][] matrix) {
        /**
            Copy elements into another array for reference.
         */

        int[][] refMatrix = new int[matrix.length][matrix.length];
        int rc = 0, cc = 0;

        while (rc != refMatrix.length) {
            if(cc == refMatrix.length) {
                rc++;
                cc=0;
                continue;
            }
            refMatrix[rc][cc] = matrix[rc][cc];
            cc++;
        }

        /**
            Rotate the matrix.
         */

        int col = 0;
        int row = matrix.length - 1;
        rc=0;
        cc=0;
        while(col < matrix.length) {
            if (row < 0) {
                col++;
                row = matrix.length - 1;
                rc++;
                cc=0;
                continue;
            }

            matrix[rc][cc] = refMatrix[row][col];

            cc++;
            row--;
        }
    }
}
