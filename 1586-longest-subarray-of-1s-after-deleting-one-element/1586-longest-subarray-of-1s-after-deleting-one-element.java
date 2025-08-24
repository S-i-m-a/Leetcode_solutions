class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0, zeroCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If we have more than one zero, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Window length minus one zero is right - left
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
