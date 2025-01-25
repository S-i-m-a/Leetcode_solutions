class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;

        // DP array
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1; // Base case

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j]; // Carry over previous results

                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }

                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}
