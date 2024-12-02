class Solution {

    // private boolean isPrefix(String searchWord, String word) {
    //     int i = 0;
    //     int m = searchWord.length(), n = word.length();
    //     while (i < m && i < n) {
    //         if (searchWord.charAt(i) != word.charAt(i)) return false;
    //         i++;
    //     }

    //     if (i == m) return true;
    //     return false;
    // }

    private boolean isPrefix(String searchWord, String sentence, int index) {
        int j = 0;    
        for (int i = index; i < sentence.length() && j < searchWord.length(); i++) {
            if (searchWord.charAt(j) != sentence.charAt(i)) return false;
            j++;
        }
        if (j == searchWord.length()) return true;
        return false;
    }
    
    public int isPrefixOfWord(String sentence, String searchWord) {
        // int i = 1;
        // for (String word : sentence.split(" ")) {
        //     if (isPrefix(searchWord, word)) return i; // can also use word.startsWith(searchWord)
        //     i++;
        // }

        int word = 1;
        for (int ptr = 0; ptr < sentence.length(); ptr++) {
            if (sentence.charAt(ptr) == searchWord.charAt(0) && isPrefix(searchWord, sentence, ptr)) return word;
            while (ptr < sentence.length() && sentence.charAt(ptr) != ' ') ptr++;
            word++;
        }

        return -1;
    }
}
