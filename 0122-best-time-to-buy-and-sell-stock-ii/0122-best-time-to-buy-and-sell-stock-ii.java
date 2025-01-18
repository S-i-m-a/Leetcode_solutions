public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        // Loop through the price array starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // If the current price is greater than the previous day's price,
            // we can capture the profit (buy at previous day's price and sell at current day's price)
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}
