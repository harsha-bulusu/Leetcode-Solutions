class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (word.length() > 0)
                    words.add(word);
                    word = "";
            } else {
                word += s.charAt(i);
            }
        }
        if (word.length() > 0) words.add(word);

        String res = "";
        for (int i = words.size() - 1; i >= 0; i--) {
            res += words.get(i);
            if (i != 0)
                res += " ";
        }
        return res;
    }
}
