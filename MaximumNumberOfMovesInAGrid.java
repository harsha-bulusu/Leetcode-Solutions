class Solution {

    private int dfs(int row, int col, int[][] grid, int dp[][]) {
        if (dp[row][col] != -1) return dp[row][col];
        
        int[] delRow = {-1, 0, 1};
        int maxMoves = 0;

        for (int i = 0; i < 3; i++) {
            int nextRow = row + delRow[i];
            int nextCol = col + 1;
            
            if (nextRow >= 0 && nextRow < grid.length && nextCol < grid[0].length 
                && grid[nextRow][nextCol] > grid[row][col]) {
                    maxMoves = Math.max(1 + dfs(nextRow, nextCol, grid, dp), maxMoves);
            }
        }
        return dp[row][col] = maxMoves;
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(dfs(i, 0, grid, dp), max);
        }
        return max;
    }
}
