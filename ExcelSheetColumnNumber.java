class Solution {

    public int titleToNumber(String columnTitle) {
       int res = 0;
       for (int i = columnTitle.length() - 1; i  >= 0; i--) {
           int pow = columnTitle.length() - 1 - i;
           res += (columnTitle.charAt(i) - 64) * Math.pow(26, pow);
       }
       return res;
    }
}
