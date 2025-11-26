class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) continue;
                for (int r = 0; r < k; ++r) {
                    int prevCount = 0;
                    if (i > 0) prevCount = (prevCount + dp[i-1][j][r]) % MOD;
                    if (j > 0) prevCount = (prevCount + dp[i][j-1][r]) % MOD;
                    if (prevCount == 0) continue;
                    int newR = (r + grid[i][j]) % k;
                    dp[i][j][newR] = (dp[i][j][newR] + prevCount) % MOD;
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}
