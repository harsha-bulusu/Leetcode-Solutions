class Solution {

    class Quadraple {
        int row;
        int col;
        int length;
        int removals;

        Quadraple(int row, int col, int length, int removals) {
            this.row = row;
            this.col = col;
            this.length = length;
            this.removals = removals;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Quadraple> minHeap = new PriorityQueue<>((q1, q2) -> {
            int res = q1.length - q2.length;
            return res == 0 ? q1.removals - q2.removals : res;
        });

        int[][] vis = new int[m][n];
        for (int[] row : vis) Arrays.fill(row, Integer.MAX_VALUE);

        minHeap.add(new Quadraple(0, 0, 0, 0));

        while (!minHeap.isEmpty()) {
            Quadraple quad = minHeap.remove();
            int row = quad.row;
            int col = quad.col;
            int removals = quad.removals;
            int length = quad.length;

            // Prune the path which has more removals - A path with min removals already exist
            if (removals >= vis[row][col]) continue;
            vis[row][col] = removals;

            if (row == m - 1 && col == n - 1) return length;

            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int newRow = delRow[i] + row;
                int newCol = delCol[i] + col;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int val = grid[newRow][newCol];
                    if (val == 1 && removals < k) {
                        minHeap.add(new Quadraple(
                            newRow, newCol,
                            length + 1, removals + 1
                        ));
                    } else if (val == 0) {
                        minHeap.add(new Quadraple(
                            newRow, newCol,
                            length + 1, removals
                        ));
                    }
                }
            }
        }

        return -1;
    }
}
