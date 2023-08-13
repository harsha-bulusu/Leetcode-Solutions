class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        double prevN = -1;
        double n = 1;
        while (prevN != n) {
            prevN = n;
            n = 0.5 * (n + (x/n));
        }
        return (int)n;
    }
}
