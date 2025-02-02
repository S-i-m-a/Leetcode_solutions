public class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize the dp array with a large value.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: 0 amount needs 0 coins.
        dp[0] = 0;
        
        // Update dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still Integer.MAX_VALUE, return -1.
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
