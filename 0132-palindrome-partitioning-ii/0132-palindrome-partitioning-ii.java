class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // dp[i] will store the minimum number of cuts required for substring s[0..i]
        int[] dp = new int[n];
        
        // palindrome[i][j] will be true if the substring s[i..j] is a palindrome
        boolean[][] palindrome = new boolean[n][n];
        
        // Initialize the dp array
        for (int i = 0; i < n; i++) {
            dp[i] = i; // The maximum cuts needed will be i (cut between each character)
        }
        
        // Fill the palindrome table
        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
                // If characters at start and end are equal and the substring is a palindrome
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || palindrome[start + 1][end - 1])) {
                    palindrome[start][end] = true;
                    
                    // If the substring s[0..end] is a palindrome, no cuts are needed
                    if (start == 0) {
                        dp[end] = 0;
                    } else {
                        dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                    }
                }
            }
        }
        
        return dp[n - 1];
    }
}
