class Solution {
    public String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String res = "";
        for (int i = 0; i < integers.length; i++) {
            int cnt = num / integers[i];
            for (int j = 0; j < cnt; j++) {
                res += romans[i];
            }
            num = num % integers[i]; 
        }

        return res;
    }
}
