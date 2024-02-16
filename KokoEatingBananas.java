class Solution {

    int findMax(int[] piles) {
        int max = piles[0];
        int n = piles.length;

        for (int i = 1; i < n; i++) {
            max = Math.max(piles[i], max);
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = findMax(piles);

        int low = 1, high = maxPile;
        int rate = -1;

        while (low <= high) {
            int k = (low + high) / 2; // the mid element

            int hoursTaken = 0;
            for (int pile : piles) {
                hoursTaken += Math.ceil((double)pile / (double)k);
            }

            if (hoursTaken <= h) {
                rate = k;
                high = k - 1;
            } else {
                low = k + 1;
            }
        }

        return rate;
    }
}
