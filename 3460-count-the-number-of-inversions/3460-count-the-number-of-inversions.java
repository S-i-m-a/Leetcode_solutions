import java.util.Arrays;

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        // Array to store required values for each position, initialized to -1
        int[] req = new int[n];
        Arrays.fill(req, -1);
      
        // Variable to store the maximum requirement value
        int maxRequirement = 0;
      
        // Populate the req array and find the maximum requirement value
        for (int[] r : requirements) {
            req[r[0]] = r[1];
            maxRequirement = Math.max(maxRequirement, r[1]);
        }
        if (req[0] > 0) {
            return 0;
        }
      
        // Set the requirement for the first position to 0
        req[0] = 0;
      
        // Define the modulus value for large numbers
        final int MOD = (int) 1e9 + 7;
      
        // Create a 2D array to store the number of valid permutations
        int[][] dp = new int[n][maxRequirement + 1];
      
        // Initialize the first position's requirement
        dp[0][0] = 1;
      
        // Iterate through positions from 1 to n-1
        for (int i = 1; i < n; ++i) {
            int left = 0, right = maxRequirement;
            if (req[i] >= 0) {
                left = right = req[i];
            }
          
            // Calculate number of permutations for each possible value of 'j'
            for (int j = left; j <= right; ++j) {
                // Add up valid permutations from previous position
                for (int k = 0; k <= Math.min(i, j); ++k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[n - 1][req[n - 1]];
    }
}