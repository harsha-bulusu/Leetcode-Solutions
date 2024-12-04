class Solution {

    private char cyclicIncrement(char ch) {
        return (char)(((int)ch - (int)'a' + 1) % 26 + (int)'a');
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int p1 = 0, p2 = 0;

        while (p1 < str1.length() && p2 < str2.length()) {
            char ch1 = str1.charAt(p1);
            char ch2 = str2.charAt(p2);
            char incrCh = cyclicIncrement(ch1);

            if (ch1 == ch2 || incrCh == ch2) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        return p2 == str2.length();
    }
}
