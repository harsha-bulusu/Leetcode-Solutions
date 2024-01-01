class Solution {

    int countPaths(int[][] grid, int m, int n, boolean[][] vis, int totalZeros, int zerosCovered) {
            if (grid[m][n] == 1 && zerosCovered == totalZeros) return 1;
            else if (grid[m][n] == 1) return 0;
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};
            int sum = 0;
            for (int i = 0; i < delRow.length; i++) {
                int nRow = delRow[i] + m;
                int nCol = delCol[i] + n;
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] != -1 && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    if (grid[nRow][nCol] == 0) ++zerosCovered;
                    sum += countPaths(grid, nRow, nCol, vis, totalZeros, zerosCovered);
                    if (grid[nRow][nCol] == 0) --zerosCovered;
                    vis[nRow][nCol] = false;
                }
            }
            return sum;
        }

        public int uniquePathsIII(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int row = 0, col = 0;
            int zeros = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        row = i;
                        col = j;
                    }
                    if (grid[i][j] == 0) {
                        zeros++;
                    }
                }
            }
            
            boolean[][] vis = new boolean[m][n];
            vis[row][col] = true;
            return countPaths(grid, row, col, vis, zeros, 0);
        }
}
