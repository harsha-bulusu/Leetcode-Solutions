class Solution {

    boolean solve(char[][] board, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    for (char val = '1'; val <= '9'; val++) {
                        if (isValid(board, row, col, val, n)) {
                            board[row][col] = val;
                            if(solve(board, n)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int row, int col, char val, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] == val) return false;
            if (board[row][i] == val) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        solve(board, n);
    }
}
