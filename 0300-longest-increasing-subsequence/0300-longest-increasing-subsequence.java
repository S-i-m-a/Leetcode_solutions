public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int length = 0;

        for (int i = 0; i < n; i++) {
            // Perform a binary search to find the position to update in the dp array
            int left = 0, right = length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[dp[mid]] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Update the dp array
            dp[left] = i;

            // If the current element is greater than all elements in dp, increase length
            if (left == length) {
                length++;
            }
        }

        return length;
    }
}
