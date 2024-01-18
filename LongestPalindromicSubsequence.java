class Solution {

    String reverse(String s) {
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;

        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;

            low++;
            high--;
        }
        return new String(chars);
    }

    int findLongestSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int prev[] = new int[n + 1];

        //base-case [0th row and 0th col should have 0's i.e., 0th index is treated as -1]

        //represent states
        for (int i = 1; i <= m; i++) {
            int curr[] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                //operate
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }

    public int longestPalindromeSubseq(String s1) {
        String s2 = reverse(s1);
        return findLongestSubsequence(s1, s2);
    }
}
