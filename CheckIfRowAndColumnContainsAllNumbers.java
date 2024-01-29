class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        System.out.println(n);

        for (int i = 0; i < n; i++) {
            int[] hash = new int[n + 1];
            for (int j = 0; j < n; j++) {
                int ele = matrix[i][j];
                hash[ele] = 1;
            }
            
            for (int j = 1; j <= n; j++) if (hash[j] == 0) return false;
        }

        for (int i = 0; i < n; i++) {
            int[] hash = new int[n + 1];
            for (int j = 0; j < n; j++) {
                int ele = matrix[j][i];
                hash[ele] = 1;
            }
            
            for (int j = 1; j <= n; j++) if (hash[j] == 0) return false;
        }

        return true;
    }
}
