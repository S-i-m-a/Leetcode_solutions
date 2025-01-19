public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // DP array to store minimum health needed at each position
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill dp array with a large value (since we want to minimize health)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // The knight needs at least 1 health at the bottom-right corner
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        // Calculate the minimum health required at each cell
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minHealthNeeded = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = minHealthNeeded > 0 ? minHealthNeeded : 1;
            }
        }

        // The answer will be at dp[0][0], which gives the minimum health needed to start
        return dp[0][0];
    }
}
