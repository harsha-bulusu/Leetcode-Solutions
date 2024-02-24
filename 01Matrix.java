class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] res = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    res[i][j] = -1;
                } else {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair node = queue.remove();
            int row = node.row;
            int col = node.col;

            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nextRow = delRow[i] + row;
                int nextCol = delCol[i] + col;

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && res[nextRow][nextCol] == -1) {
                    res[nextRow][nextCol] = res[row][col] + 1;
                    queue.add(new Pair(nextRow, nextCol));
                }
             }
        }

        return res;

        


    }
}
