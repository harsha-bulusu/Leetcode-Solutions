class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] >= prices[j]) {
                    res[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == -1) res[i] = prices[i];
        }
        return res;
    }
}
