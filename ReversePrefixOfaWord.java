class Solution {
    public String reversePrefix(String word, char ch) {
        int high = word.indexOf(ch);
        int low = 0;
        char[] s = word.toCharArray();
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;

            low++;
            high--;
        }

        return new String(s);
    }
}
