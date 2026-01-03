class Solution {
    public int numOfWays(int n) {
        // Define modulo constant for large number handling
        final int MOD = (int) 1e9 + 7;
      
        // Initialize counts for two pattern types:
        // twoColorPattern: patterns using 2 colors (ABA type) - initially 6 ways
        // threeColorPattern: patterns using 3 colors (ABC type) - initially 6 ways
        long twoColorPattern = 6;
        long threeColorPattern = 6;
      
        // Build up the grid row by row
        for (int row = 0; row < n - 1; row++) {
            // Calculate next row's pattern counts based on current row
            // For ABA type: can be followed by 3 ABA patterns + 2 ABC patterns
            long nextTwoColorPattern = (3 * twoColorPattern + 2 * threeColorPattern) % MOD;
          
            // For ABC type: can be followed by 2 ABA patterns + 2 ABC patterns
            long nextThreeColorPattern = (2 * twoColorPattern + 2 * threeColorPattern) % MOD;
          
            // Update pattern counts for next iteration
            twoColorPattern = nextTwoColorPattern;
            threeColorPattern = nextThreeColorPattern;
        }
      
        // Return total number of ways (sum of both pattern types)
        return (int) ((twoColorPattern + threeColorPattern) % MOD);
    }
}