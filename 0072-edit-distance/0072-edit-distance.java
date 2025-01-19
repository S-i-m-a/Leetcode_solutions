class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D DP array with dimensions (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // It takes i deletions to convert word1[0...i] to ""
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // It takes j insertions to convert "" to word2[0...j]
        }
        
        // Fill the DP table using the recurrence relation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // No operation needed if characters match
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // Take the minimum of:
                    // 1. Deletion (dp[i-1][j])
                    // 2. Insertion (dp[i][j-1])
                    // 3. Replacement (dp[i-1][j-1])
                }
            }
        }
        
        // The answer is the value at dp[m][n]
        return dp[m][n];
    }
}
