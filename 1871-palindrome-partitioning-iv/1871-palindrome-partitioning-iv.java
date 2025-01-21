class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        
        // Table to store if substring s[i..j] is a palindrome
        boolean[][] palindrome = new boolean[n][n];
        
        // Fill the palindrome table
        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {
                // A substring is a palindrome if the characters at the ends match
                // and the inner substring is also a palindrome, or the length is <= 2
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || palindrome[start + 1][end - 1])) {
                    palindrome[start][end] = true;
                }
            }
        }
        
        // dp[i] will store if it's possible to split the string up to index i into 3 palindromic parts
        boolean[] dp = new boolean[n];
        
        // First partition (leftmost part)
        for (int mid1 = 1; mid1 < n; mid1++) {
            if (palindrome[0][mid1 - 1]) {
                // Second partition (middle part)
                for (int mid2 = mid1 + 1; mid2 < n; mid2++) {
                    if (palindrome[mid1][mid2 - 1] && palindrome[mid2][n - 1]) {
                        return true; // Found 3 palindromic partitions
                    }
                }
            }
        }
        
        return false; // No valid partitioning
    }
}
