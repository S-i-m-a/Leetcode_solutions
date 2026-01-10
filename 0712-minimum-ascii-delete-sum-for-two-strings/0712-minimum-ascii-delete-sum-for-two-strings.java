class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // dp[i][j] = minimum ASCII delete sum to make s1[0..i-1] and s2[0..j-1] equal
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        // Base cases: delete all characters when one string is empty
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        
        // Fill dp
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int deleteFromS1 = dp[i - 1][j] + s1.charAt(i - 1);
                    int deleteFromS2 = dp[i][j - 1] + s2.charAt(j - 1);
                    dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
                }
            }
        }
        
        return dp[n1][n2];
    }
}
