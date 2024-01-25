class Solution {

    int longestCommonSubsequence(int m, int n, String s1, String s2) {
        int prev[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int curr[] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[n];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        return m + n - 2 * longestCommonSubsequence(m, n, word1, word2);
    }
}
