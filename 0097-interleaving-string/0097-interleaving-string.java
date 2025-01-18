public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // Create a DP table
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // Initialize the DP table
        dp[0][0] = true;

        // Fill the DP table
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // Check if we can take a character from s1
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                // Check if we can take a character from s2
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        // The answer is whether we can interleave the entire s1 and s2 into s3
        return dp[s1.length()][s2.length()];
    }
}
