class Solution {
    public int mySqrt(int x) {
        long X = x;
        if (x == 0 || x == 1) return x;

        long low = 0, high = X;
        long ans = x;
        while (low <= high) {
            long mid = (low + high) / 2;
            if ((mid * mid) <= X) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)ans;
    }
}
