class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
            }
            profit = Math.max(max - min, profit);
        }
        return profit;
    }

}
