class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;

        while (x != 0 || y != 0) {
            int xBit = x & 1;
            int yBit = y & 1;
            if (xBit != yBit) res++;
            x >>= 1;
            y >>= 1;
        }

        return res;
    }
}
