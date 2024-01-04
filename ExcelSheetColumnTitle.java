class Solution {

    char convertIntegerToAlphabet(int val) {
        return (char) (64 + val);
    }

    public String convertToTitle(int columnNumber) {
        String res = "";
        if (columnNumber <= 26) {
            res += convertIntegerToAlphabet(columnNumber);
            return res;
        }
        int quotient = columnNumber / 26;
         if (columnNumber % 26 == 0) {
                quotient--;
            }
        if (quotient > 26) {
            res += convertToTitle(quotient);
        } else {
            res += convertIntegerToAlphabet(quotient);
        }
        int nextChar = columnNumber - 26 * quotient;
        res += convertIntegerToAlphabet(nextChar);
        return res;
    }
}
