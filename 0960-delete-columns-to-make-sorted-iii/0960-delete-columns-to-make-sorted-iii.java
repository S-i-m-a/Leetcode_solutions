class Solution {
    public int minDeletionSize(String[] strs) {
        // k = number of columns (length of each string)
        final int k = strs[0].length();
        
        // dp[i] = length of longest valid subsequence of columns ending at i
        int[] dp = new int[k];
        Arrays.fill(dp, 1); // each single column is a subsequence of length 1

        int maxLen = 1;

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < i; j++) {
                if (canFollow(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        // Minimum deletions = total columns − longest valid subsequence
        return k - maxLen;
    }

    // check if column j can come before column i in the sorted columns
    private boolean canFollow(String[] strs, int j, int i) {
        for (String s : strs) {
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
