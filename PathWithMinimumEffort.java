class Tuple {
    int row;
    int col;
    int diff;

    public Tuple(int row, int col, int diff) {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
       int n = heights.length;
       int m = heights[0].length;
       int dif[][] = new int[n][m]; 

       for (int i = 0; i < n; i++) {
           Arrays.fill(dif[i], (int)1e9);
       }
       dif[0][0] = 0;

       PriorityQueue<Tuple> queue = new PriorityQueue<>((t1, t2) -> t1.diff - t2.diff);
       queue.add(new Tuple(0, 0, 0));
       int delRow[] = {-1, 0, 1, 0};
       int delCol[] = {0, -1, 0, 1};

       while (!queue.isEmpty()) {
           Tuple tuple = queue.remove();
           int row = tuple.row;
           int col = tuple.col;
           int diff = tuple.diff;

           if (row == n - 1 && col == m - 1) {
               return diff;
           }

           for (int i = 0; i < 4; i++) {
               int nextRow = row + delRow[i];
               int nextCol = col + delCol[i];

               if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                   int newDiff = Math.max(diff, Math.abs(heights[nextRow][nextCol] - heights[row][col]));

                   if (newDiff < dif[nextRow][nextCol]) {
                       dif[nextRow][nextCol] = newDiff;
                       queue.add(new Tuple(nextRow, nextCol, newDiff));
                   }
               }
           }
       }

       return 0;
    }
}
