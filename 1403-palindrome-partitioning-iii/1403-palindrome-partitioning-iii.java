class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        
        // dp[i][j] will store the minimum number of changes required to partition s[0..i] into j palindromic substrings
        int[][] dp = new int[n + 1][k + 1];
        
        // cost[i][j] will store the number of changes required to make the substring s[i..j] a palindrome
        int[][] cost = new int[n][n];
        
        // Fill the cost table for all substrings of s
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (i == j) {
                    cost[i][j] = 0; // A single character is always a palindrome
                } else {
                    cost[i][j] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
                    if (j - i > 1) {
                        cost[i][j] += cost[i + 1][j - 1]; // Add the cost of making s[i+1..j-1] a palindrome
                    }
                }
            }
        }
        
        // Initialize dp array for 1 palindrome (no cuts needed)
        for (int i = 1; i <= n; i++) {
            dp[i][1] = cost[0][i - 1]; // Min changes to make s[0..i-1] a palindrome
        }
        
        // Fill the dp array for multiple palindromes
        for (int j = 2; j <= k; j++) {
            for (int i = j - 1; i < n; i++) {
                dp[i + 1][j] = Integer.MAX_VALUE;
                for (int x = j - 2; x < i; x++) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[x + 1][j - 1] + cost[x + 1][i]);
                }
            }
        }
        
        return dp[n][k];
    }
}
