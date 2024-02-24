class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new Pair(i, 0));
                vis[i][0] = true;
            } 

            if (board[i][n - 1] == 'O') {
                queue.add(new Pair(i, n - 1));
                vis[i][n - 1] = true;
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                queue.add(new Pair(0, j));
                vis[0][j] = true;
            }

            if (board[m - 1][j] == 'O') {
                queue.add(new Pair (m -1, j));
                vis[m - 1][j] = true;
            } 
        }

        while (!queue.isEmpty()) {
            Pair cell = queue.remove();
            int row = cell.row;
            int col = cell.col;

            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nextRow = row + delRow[i];
                int nextCol = col + delCol[i];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && board[nextRow][nextCol] == 'O' && !vis[nextRow][nextCol]) {
                    queue.add(new Pair(nextRow, nextCol));
                    vis[nextRow][nextCol] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
