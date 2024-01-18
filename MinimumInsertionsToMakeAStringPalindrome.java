class Solution {

    int longestCommonSubsequence(String s1, String s2) { // refer longest common subsequence problem for more info
        int m = s1.length();
        int n = s2.length();
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

    String reverse(String s){
        int low = 0;
        int high = s.length() - 1;
        char chars[] = s.toCharArray();
        while(low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;

            low++;
            high--;
        }
        return new String(chars);
    }

    int longestPalindromicSubsequence(String s1) {
        String s2 = reverse(s1);
        return longestCommonSubsequence(s1, s2);
    }

    public int minInsertions(String s) {
        return s.length() - longestPalindromicSubsequence(s);
    }
}
