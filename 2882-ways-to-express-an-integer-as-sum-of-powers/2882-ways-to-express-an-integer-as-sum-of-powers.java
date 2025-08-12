class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;

        // dp[s] = number of ways to reach sum 's' using unique xth-powers
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // For each base 'a' from 1 upward, compute a^x
        for (int a = 1; ; a++) {
            long power = 1;
            for (int i = 0; i < x; i++) {
                power *= a;
                if (power > n) break;
            }
            if (power > n) break;

            int p = (int) power;
            // Update DP in reverse to maintain uniqueness
            for (int s = n; s >= p; s--) {
                dp[s] = (dp[s] + dp[s - p]) % MOD;
            }
        }

        return dp[n];
    }
}
