class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n][k + 1][3];
        for (int txn = 1; txn <= k; txn++) {
            dp[0][txn][1] = -prices[0];
            dp[0][txn][2] = prices[0];
        }
      
        for (int day = 1; day < n; day++) {
            for (int txn = 1; txn <= k; txn++) {
                dp[day][txn][0] = Math.max(
                    dp[day - 1][txn][0],
                    Math.max(
                        dp[day - 1][txn][1] + prices[day],  // Sell bought stock
                        dp[day - 1][txn][2] - prices[day]   // Cover shorted stock
                    )
                );
                dp[day][txn][1] = Math.max(
                    dp[day - 1][txn][1],
                    dp[day - 1][txn - 1][0] - prices[day]  // Buy stock
                );
                dp[day][txn][2] = Math.max(
                    dp[day - 1][txn][2],
                    dp[day - 1][txn - 1][0] + prices[day]  // Short stock
                );
            }
        }
        return dp[n - 1][k][0];
    }
}