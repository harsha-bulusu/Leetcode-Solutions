class Solution {

    class Triplet {
        int row;
        int col;
        int removals;

        Triplet(int row, int col, int removals) {
            this.row = row;
            this.col = col;
            this.removals = removals;
        }
    }   

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((t1, t2) -> t1.removals - t2.removals);
        boolean[][] vis = new boolean[m][n];

        vis[0][0] = true;
        minHeap.add(new Triplet(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Triplet triplet = minHeap.poll();
            int row = triplet.row;
            int col = triplet.col;
            int removals = triplet.removals;

            if (row == m - 1 && col == n - 1) return removals;

            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int newRow = delRow[i] + row;
                int newCol = delCol[i] + col;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    minHeap.add(new Triplet(newRow, newCol, 
                            grid[newRow][newCol] == 0 ? removals : removals + 1)
                    );
                }
            }
        }

        return -1;
    }
}
