class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // dp[i][j] = max dot product for nums1 up to i and nums2 up to j
        int[][] dp = new int[m + 1][n + 1];

        // Initialize dp with very small values because we require non-empty subsequences
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Option 1: skip element from nums1
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // Option 2: skip element from nums2
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);

                // Option 3: use both nums1[i-1] and nums2[j-1]
                int prod = nums1[i - 1] * nums2[j - 1];
                // If dp[i-1][j-1] is negative, we can start fresh with just prod
                dp[i][j] = Math.max(dp[i][j], Math.max(0, dp[i - 1][j - 1]) + prod);
            }
        }

        return dp[m][n];
    }
}
