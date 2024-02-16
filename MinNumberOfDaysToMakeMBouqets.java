class Solution {

    int findMaxDay(int []bloomDay) {
        int max = bloomDay[0];
        int n = bloomDay.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, bloomDay[i]);
        }
        return max;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1, high = findMaxDay(bloomDay);
        int minDays = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2; // mid-day
            int flowersCount = 0;
            int totalBouqets = 0;
            for (int i : bloomDay) {
                if (i <= mid) {
                    flowersCount++;
                    if (flowersCount == k) {
                        totalBouqets++;
                        flowersCount = 0;
                    }
                } else {
                    flowersCount = 0;
                }
            }

            if (totalBouqets >= m) {
                minDays = Math.min(minDays, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minDays == Integer.MAX_VALUE ? -1 : minDays;
    }
}
