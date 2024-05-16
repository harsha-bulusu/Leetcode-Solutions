class Solution {

    private boolean isValidEntry(boolean[] values, char ch) {
         if (Character.isDigit(ch)) {
            int ele = Character.getNumericValue(ch);
            if (!values[ele]) values[ele] = true;
            else return false;
        }
        return true;
    }

    private boolean validateRow(char[][] board) {
        for (char[] row : board) {
            boolean[] values = new boolean[10];
            for (char ch : row) {
                if (!isValidEntry(values, ch)) return false; 
            }
        }
        return true;
    }

    private boolean validateColumn(char[][] board) {
        for (int col = 0; col <= 8; col++) {      
            boolean[] values = new boolean[10];  
            for (int row = 0; row <= 8; row++) {
                char ch = board[row][col];
                if (!isValidEntry(values, ch)) return false;
            }
        }
        return true;
    }

    private boolean validateBoxes(char[][] board) {
        int[][] pts = {
            {0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}
        };

        for (int[] pt : pts) {
            int sr = pt[0];
            int sc = pt[1];
            boolean[] values = new boolean[10];
            for (int i = sr; i < sr + 3; i++) {
                for (int j = sc; j < sc + 3; j++) {
                    char ch = board[i][j];
                    if (!isValidEntry(values, ch)) return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return validateRow(board) && validateColumn(board) && validateBoxes(board);
    }
}
