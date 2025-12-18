class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int h = k / 2;

        long p_original = 0;
        for (int i = 0; i < strategy.length; i++) {
            p_original += (long)strategy[i] * prices[i];
        }

        // Calculate for the first window (j=0)
        long new_profit_segment = 0;
        for (int i = h; i < k; i++) {
            new_profit_segment += prices[i];
        }

        long old_profit_segment = 0;
        for (int i = 0; i < k; i++) {
            old_profit_segment += (long)strategy[i] * prices[i];
        }

        long current_delta = new_profit_segment - old_profit_segment;
        long max_delta = Math.max(0, current_delta);

        // Slide the window from j=1 to n-k
        for (int j = 1; j <= n - k; j++) {
            old_profit_segment = old_profit_segment - ((long)strategy[j-1] * prices[j-1]) + ((long)strategy[j+k-1] * prices[j+k-1]);
            new_profit_segment = new_profit_segment - prices[j-1+h] + prices[j+k-1];

            current_delta = new_profit_segment - old_profit_segment;
            max_delta = Math.max(max_delta, current_delta);
        }

        return p_original + max_delta;
    }
}