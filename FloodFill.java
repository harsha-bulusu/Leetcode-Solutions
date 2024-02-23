class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];
        int toBeColored = image[sr][sc];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = image[i][j];
            }
        }


        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        res[sr][sc] = color;
        
        while (!queue.isEmpty()) {
            Pair cell = queue.remove();
            int row = cell.row;
            int col = cell.col;

            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nextRow = row + delRow[i];
                int nextCol = col + delCol[i];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && image[nextRow][nextCol] == toBeColored && res[nextRow][nextCol] != color) {
                    res[nextRow][nextCol] = color;
                    queue.add(new Pair(nextRow, nextCol));
                }
            } 
        }

        return res;
    } 
}
