class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        long temp = 0, quotient = 0;

        for (int i=31; i>=0; --i) {
            if (temp + (b << i) <= a) {
                temp+= b << i;
                quotient |= 1L << i;
            }
        }

        return (int)quotient*sign;
    }
}
