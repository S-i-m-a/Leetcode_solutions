class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        // Target sum for each subset
        int target = totalSum / 2;

        // DP array to check if a sum is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: a sum of 0 is always possible

        // Iterate through the numbers in the array
        for (int num : nums) {
            // Update the DP array from right to left
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // The answer is whether the target sum is achievable
        return dp[target];
    }
}
