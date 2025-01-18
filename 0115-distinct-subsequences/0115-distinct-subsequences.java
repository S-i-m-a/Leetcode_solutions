public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // DP table, dp[i][j] represents the number of ways to form the first j characters of t using the first i characters of s
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: An empty string t can be formed by any string s in exactly one way
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, there are two possibilities:
                    // 1. Include s[i-1] in the subsequence
                    // 2. Exclude s[i-1] from the subsequence
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, we can only exclude s[i-1] from the subsequence
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The result is stored in dp[m][n]
        return dp[m][n];
    }
}
