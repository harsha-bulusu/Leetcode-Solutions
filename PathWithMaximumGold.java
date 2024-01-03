class Solution {

    int f(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int currValue = grid[i][j];
        grid[i][j] = 0;
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < delRow.length; idx++) {
            int nRow = delRow[idx] + i;
            int nCol  = delCol[idx] + j;
            max = Math.max(max, f(grid, nRow, nCol));
            
        }
        grid[i][j] = currValue;
        return max + currValue;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    max = Math.max(max, f(grid, i, j));
            }
        }

        return max;
    }
}
