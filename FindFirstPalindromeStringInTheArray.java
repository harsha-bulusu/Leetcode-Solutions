class Solution {

    boolean isPalindrome(String word) {
        int low = 0;
        int high = word.length() - 1;
        while (low < high) {
            if (word.charAt(low) != word.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) return word;
        }
        return "";
    }
}
