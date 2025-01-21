class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;

        while (right < n) {
            // Add the current element to the window sum
            currentSum += nums[right];
            right++;

            // Shrink the window if the sum is greater than or equal to target
            while (currentSum >= target) {
                // Update the minimum length
                minLength = Math.min(minLength, right - left);

                // Remove the element at 'left' from the window and move left pointer
                currentSum -= nums[left];
                left++;
            }
        }

        // If no valid subarray was found, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
