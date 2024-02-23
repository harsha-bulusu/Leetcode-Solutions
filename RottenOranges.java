class Solution {

    class Data {
        int row;
        int col;
        int min;

        public Data(int row, int col, int min) {
            this.row = row;
            this.col = col;
            this.min = min;
        }
    }

    int bfs(int[][] grid, int m, int n, Queue<Data> queue) {

        int rowDel[] = {-1, 0, 1, 0};
        int colDel[] = {0, -1, 0, 1};

        int min = 0;
        while (!queue.isEmpty()) {
            Data cell = queue.remove();
            min = cell.min;

            for (int i = 0; i < 4; i++) {
                int nextRow = cell.row + rowDel[i];
                int nextCol = cell.col + colDel[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    queue.add(new Data(nextRow, nextCol, cell.min + 1));
                } 
            }
        }
        return min;
        
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Data> queue = new LinkedList<>();
        int min = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Data(i, j, 0));
                    
                }
            }
        }

        min = bfs(grid, m, n, queue);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return min;
    }
}
