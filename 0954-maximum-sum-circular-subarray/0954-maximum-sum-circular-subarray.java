class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE, curMax = 0;
        int minSum = Integer.MAX_VALUE, curMin = 0;

        for (int num : nums) {
            // Compute maximum subarray sum using Kadane's algorithm
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // Compute minimum subarray sum using Kadane's algorithm
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            // Sum of all elements in the array
            totalSum += num;
        }

        // If all elements are negative, maxSum will be the largest element
        if (maxSum < 0) {
            return maxSum;
        }

        // The max circular sum is max of (normal max subarray sum, totalSum - minSum)
        return Math.max(maxSum, totalSum - minSum);
    }
}
