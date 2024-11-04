class Solution {

    int cursor = 0; // points to index where first character has started

    private void fillDigits(int digits, char[] chars, int cnt) {
        cursor += digits;
        while (cnt != 0) {
            chars[cursor--] = (char)((cnt % 10) + '0');
            cnt /= 10;
        }
        cursor += (digits + 1);
    }

    private void helper(int cnt, char[] chars, char ch) {
        chars[cursor] = ch;
        if (cnt == 1) {
            cursor++;
        } else if (cnt <= 9) {
            fillDigits(1, chars, cnt);
        }
        else if (cnt <= 99) {
            fillDigits(2, chars, cnt);
        }
        else if (cnt <= 999) {
            fillDigits(3, chars, cnt);
        }
        else if (cnt <= 2000) {
            fillDigits(4, chars, cnt);
        }
    }

    public int compress(char[] chars) {

        if (chars.length == 1) return 1;
        
        int cnt = 1;
        int charRef = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[charRef] == chars[i]) {
                cnt++;
            } else {
                helper(cnt, chars, chars[charRef]);
                cnt = 1;
                charRef = i;
            }
        }

        helper(cnt, chars, chars[charRef]);
        return cursor;
    }
}
