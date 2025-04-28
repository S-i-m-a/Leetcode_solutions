public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0, right = 0;
        long sum = 0;
        long count = 0;

        while (left < n) {
            // Expand the window to the right as far as the score constraint is satisfied
            while (right < n && (sum + nums[right]) * (right - left + 1) < k) {
                sum += nums[right];
                right++;
            }

            // All subarrays starting at 'left' and ending before 'right' are valid
            count += right - left;

            // Shrink the window from the left
            if (right == left) {
                // If we couldn't include nums[left], move both pointers forward
                right++;
            } else {
                sum -= nums[left];
            }
            left++;
        }

        return count;
    }
}
