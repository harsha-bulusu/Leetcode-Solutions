class Solution {
    public void setZeroes(int[][] matrix) {

        boolean hasZero = false;
        int rc = 0; //row_cursor
        int cc = 0; //column_cursor
        List<Integer> colIndex = new ArrayList<>();

        // for making rows as zero
        while(rc < matrix.length) {
            if (cc == matrix[0].length) {
                rc++;
                cc=0;
                hasZero = false;
                continue;
            }

            if (matrix[rc][cc] == 0) {
                if(!hasZero) {
                    hasZero = true;
                    cc=0;
                    continue;
                } else {
                    colIndex.add(cc);
                }
                
            }
            
            if(hasZero) {
                matrix[rc][cc] = 0;
            }

            cc++;
        }


        //Making column values to zeros
        rc = 0;
        int cursor = 0; //cursor to point to column indexes list
        cc = 0;
        while(cursor < colIndex.size()) {
            if (rc == matrix.length) {
                rc = 0;
                cursor++;
                continue;
            }
            cc = colIndex.get(cursor);
            matrix[rc][cc] = 0;
            rc++;
        }



        
    }
}
