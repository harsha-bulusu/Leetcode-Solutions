class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            int currProfit = prices[i] - minPrice;
            maxProfit = Math.max(currProfit, maxProfit);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }
}
