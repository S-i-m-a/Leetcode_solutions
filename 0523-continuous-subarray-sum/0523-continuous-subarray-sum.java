import java.util.HashMap;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Step 1: Initialize HashMap to track remainders
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Handle the case when the entire prefix sum is divisible by k

        int prefixSum = 0;

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Handle negative k by normalizing the remainder
            int remainder = k == 0 ? prefixSum : (prefixSum % k + k) % k;

            // Check if the remainder is already in the map
            if (remainderMap.containsKey(remainder)) {
                // Ensure the subarray length is at least 2
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the remainder and index if not already present
                remainderMap.put(remainder, i);
            }
        }

        return false; // No valid subarray found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // Output: true
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)); // Output: false
        System.out.println(solution.checkSubarraySum(new int[]{5, 0, 0, 0}, 0)); // Output: true
    }
}
