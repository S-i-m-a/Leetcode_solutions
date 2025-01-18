public class Solution {
    public int pivotIndex(int[] nums) {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Initialize left sum to 0
        int leftSum = 0;

        // Step 3: Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            // Step 4: Calculate the right sum
            int rightSum = totalSum - leftSum - nums[i];

            // Step 5: Check if left sum equals right sum
            if (leftSum == rightSum) {
                return i; // Return the pivot index
            }

            // Step 6: Update the left sum by adding the current element
            leftSum += nums[i];
        }

        // Step 7: If no pivot index is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // Output: 3
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3})); // Output: -1
        System.out.println(solution.pivotIndex(new int[]{2, 1, -1})); // Output: 0
    }
}
