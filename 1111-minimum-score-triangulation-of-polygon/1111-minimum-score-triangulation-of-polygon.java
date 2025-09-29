class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // dp[i][j] = minimum score to triangulate the polygon formed by vertices i..j (inclusive)
        int[][] dp = new int[n][n];
        
        // We only consider intervals of length ≥ 3 (i.e. j − i ≥ 2)  
        // because you need at least 3 points to form a triangle.
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                
                // try every possible k between i and j to form a triangle (i, k, j)
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
