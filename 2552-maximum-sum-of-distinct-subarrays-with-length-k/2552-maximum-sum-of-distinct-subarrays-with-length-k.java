class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;   // Store the length of input array nums
        // Create a HashMap to count the occurrences of each number in a subarray of size k
        Map<Integer, Integer> countMap = new HashMap<>(k);
        long sum = 0;  // Initialize sum of elements in the current subarray
      
        // Traverse the first subarray of size k and initialize the countMap and sum
        for (int i = 0; i < k; ++i) {
            countMap.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
        }
      
        // Initialize the answer with the sum of the first subarray if all elements are unique
        long maxSum = countMap.size() == k ? sum : 0;
      
        // Loop over the rest of the array, updating subarrays and checking for maximum sum
        for (int i = k; i < n; ++i) {
            // Add current element to the countMap and update the sum
            countMap.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
          
            // Remove the element that's k positions behind the current one from countMap and update the sum
            int count = countMap.merge(nums[i - k], -1, Integer::sum);
            if (count == 0) {
                countMap.remove(nums[i - k]);
            }
            sum -= nums[i - k];
          
            // Update maxSum if the countMap indicates that we have a subarray with k unique elements
            if (countMap.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
      
        // Return the maximum sum found
        return maxSum;
    }
}