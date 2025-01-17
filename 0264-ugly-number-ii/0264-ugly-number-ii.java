class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        
        for (int i = 1; i < n; i++) {
            // The next ugly number is the minimum of the next multiples of 2, 3, and 5
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            dp[i] = nextUgly;
            
            // Update the pointers for the corresponding multiples
            if (nextUgly == next2) {
                next2 = 2 * dp[++i2];
            }
            if (nextUgly == next3) {
                next3 = 3 * dp[++i3];
            }
            if (nextUgly == next5) {
                next5 = 5 * dp[++i5];
            }
        }
        
        return dp[n - 1]; // Return the nth ugly number
    }
}
