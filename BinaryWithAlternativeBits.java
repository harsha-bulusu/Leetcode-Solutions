class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = -1;
        while (n != 0) {
            if ((n & 1) != prevBit) {
                prevBit = n & 1;
                n >>= 1;
            }
            else return false;
        }

        return true;
    }
}
