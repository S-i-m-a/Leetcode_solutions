import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // Step 1: Initialize variables
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Handle the case when prefixSum itself is equal to k
        int count = 0;
        int prefixSum = 0;

        // Step 2: Iterate through the array
        for (int num : nums) {
            prefixSum += num; // Update the running sum

            // Step 3: Check if (prefixSum - k) exists in the map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k); // Increment count
            }

            // Step 4: Update the map with the current prefixSum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count; // Return the total number of subarrays
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2)); // Output: 2
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3)); // Output: 2
        System.out.println(solution.subarraySum(new int[]{-1, -1, 1}, 0)); // Output: 1
    }
}
