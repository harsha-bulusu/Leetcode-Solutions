class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder("");

        char prev = word.charAt(0);
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == prev && cnt < 9) {
                cnt++;
            } else {
                comp.append(cnt + "" + prev);
                prev = word.charAt(i);
                cnt = 1;
            }
        }
        comp.append(cnt + "" + prev);

        return comp.toString();
    }
}
