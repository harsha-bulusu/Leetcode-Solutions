class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - min;
            totalProfit = Math.max(currProfit, totalProfit);
            min = Math.min(min, prices[i]);
        }

        return totalProfit;
    }
}
