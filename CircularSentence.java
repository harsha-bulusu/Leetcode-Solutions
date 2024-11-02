class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.charAt(w1.length() - 1) != w2.charAt(0)) return false;
        }

        return words[0].charAt(0) == words[n - 1].charAt(words[n - 1].length() - 1);
    }
}
