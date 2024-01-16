class Solution {
    public int prefixCount(String[] words, String pref) {
        int count  = 0;
        int prefLen = pref.length();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLength = word.length();
            boolean match = true;
            if (wordLength < prefLen) continue;
            for (int j = 0; j < prefLen; j++) {
                if (word.charAt(j) != pref.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) count++;
        }

        return count;
    }
}
