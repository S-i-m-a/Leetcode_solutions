class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize the variables to store the current sum and maximum sum
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update the current sum to either include the current element
            // or start a new subarray with the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
