class Solution {

    boolean isAlpha(int ch) {
        if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) return true;
        return false;
    }

    public String reverseOnlyLetters(String s) {
        int low = 0;
        int high = s.length() - 1;
        char str[] = s.toCharArray();

        while (low < high) {
            boolean isLowAlpha  = isAlpha(str[low]);
            boolean isHighAlpha = isAlpha(str[high]);
            if (isLowAlpha && isHighAlpha) {
                char temp = str[low];
                str[low] = str[high];
                str[high] = temp;

                high--;
                low++;
            }

            if (!isLowAlpha) {
                low++;
            }
            if (!isHighAlpha) {
                high--;
            }
        }
        return new String(str);
    }
}
