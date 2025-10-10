import java.util.Arrays;

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = Arrays.copyOf(energy, n);
        
        // Traverse the array from the end to the (k)-th index
        for (int i = n - 1 - k; i >= 0; --i) {
            dp[i] += dp[i + k];
        }
        
        // Return the maximum value from the dp array
        return Arrays.stream(dp).max().getAsInt();
    }
}
