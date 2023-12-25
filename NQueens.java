class Solution {

    List<String> construct(char[][] board) {
        int n = board.length;
        List<String> tBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += board[i][j];
            }
            tBoard.add(row);
        }
        return tBoard;
    }

    void solve(int col, char[][] board, List<List<String>> ans,
     int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n){
         if (col == n) {
             ans.add(construct(board));
             return;
         }

         for (int row = 0; row < n; row++) {
             if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                 board[row][col] = 'Q';
                 leftRow[row] = 1;
                 lowerDiagonal[row + col] = 1;
                 upperDiagonal[n - 1 + col - row] = 1;
                 solve(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
                 board[row][col] = '.';
                 leftRow[row] = 0;
                 lowerDiagonal[row + col] = 0;
                 upperDiagonal[n - 1 + col - row] = 0;
             }
         }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int[] leftRow = new int[n];
        int diagonalSize = (2 * n) - 1;
        int[] lowerDiagonal = new int[diagonalSize];
        int[] upperDiagonal = new int[diagonalSize];
        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
        return ans;
    }
}
