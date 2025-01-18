public class Solution {
    public int numTrees(int n) {
        // dp[i] will store the number of unique BSTs that can be formed with 'i' nodes.
        int[] dp = new int[n + 1];
        
        // Base case: an empty tree (0 nodes) or a single node tree (1 node) is always 1.
        dp[0] = 1;
        dp[1] = 1;
        
        // Fill the dp array for all numbers from 2 to n.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        // The result for n nodes is stored in dp[n].
        return dp[n];
    }
}
