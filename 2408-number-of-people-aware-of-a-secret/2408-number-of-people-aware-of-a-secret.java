class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long share = 0;
        int[] dp = new int[n];  // dp[i]: number of people who learn the secret on day i+1
        dp[0] = 1;  // Day 1: one person learns the secret

        for (int i = 1; i < n; ++i) {
            if (i - delay >= 0) {
                share = (share + dp[i - delay]) % MOD;
            }
            if (i - forget >= 0) {
                share = (share - dp[i - forget] + MOD) % MOD;
            }
            dp[i] = (int) share;
        }

        // Sum up those who still remember the secret at end of day n
        int ans = 0;
        for (int i = n - forget; i < n; ++i) {
            ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
}
