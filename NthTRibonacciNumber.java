class Solution {

    /**
        * recursive approach
     */

    private int trib(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != -1) return dp[n];

        return dp[n] = (trib(n - 1, dp) + trib(n - 2, dp) + trib(n - 3, dp));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        int a = 0, b = 1, c = 1;

        for (int i = 3;  i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return trib(n, dp);
    }
}
