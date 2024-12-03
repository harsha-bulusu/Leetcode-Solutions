class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int i = 0;

        for (int space : spaces) {
            while (i != space) {
                res.append(s.charAt(i));
                i++;
            }
            res.append(' ');
        }

        while (i < s.length()) {
            res.append(s.charAt(i));
            i++;
        }

        return res.toString();
    }
}

/**
    * The alternative is to construct an array instead of using string buffer or builder
 */
