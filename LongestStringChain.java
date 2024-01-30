class Solution {

    static boolean isChain(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }

    public int longestStrChain(String[] words) {
        List<String> list = Arrays.asList(words);
        list.sort((w1, w2) -> w1.length() - w2.length());

        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < list.size(); i++) {
            for (int prev = i - 1; prev >= 0; prev--) {
                if (isChain(list.get(i), list.get(prev)) && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;

    }
}
