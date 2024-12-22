class Solution {

    private static final int MOD = 1000000007;
    
    // Memoize the changing parameters (row, col, path) && DP stores the res (#Paths)
    private int dfs(int row, int col, int xor, int[][] grid, int k, int[][][] dp) {
        if (row == grid.length - 1 && col == grid[0].length  - 1) {
            return (xor == k) ? 1 : 0;
        }

        if (dp[row][col][xor] != -1) return dp[row][col][xor];
        
        int cnt = 0;
        // right
        if (col + 1 < grid[0].length)
            cnt = (cnt + dfs(row, col + 1, xor ^ grid[row][col + 1], grid, k, dp)) % MOD;
        // down
        if (row + 1 < grid.length)
            cnt = (cnt + dfs(row + 1, col, xor ^ grid[row + 1][col], grid, k, dp)) % MOD;
        
        return dp[row][col][xor] = cnt;
    }
    
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int maxXor = 1 << 7; // since grid[r][c] 1 <= 16 (4-bit)
        int dp[][][] = new int[m][n][maxXor];

        for (int mat[][] : dp) {
            for (int row[] : mat) {
                Arrays.fill(row, -1);
            }
        }

        return dfs(0, 0, grid[0][0], grid, k, dp);
    }
}
