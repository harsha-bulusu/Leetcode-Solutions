class Solution {

    void reverse(char s[], int low, int high) {
        if (high >= s.length) high = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;

            low++;
            high--;
        }

    }

    public String reverseStr(String s, int k) {
        int index = 0;
        char[] str = s.toCharArray();
        while (index < s.length()) {
            reverse(str, index, (index + k) - 1);
            index += 2 * k;
        }
        return new String(str);
    }
}
