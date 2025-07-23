class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no change needed
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(dp[i - 1][j], // delete
                                 dp[i][j - 1]) // insert
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}
