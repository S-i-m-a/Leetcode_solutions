public class Solution {
    public int maxAdjacentDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int n = nums.length;
        int maxDifference = Integer.MIN_VALUE;

        // Iterate through the array to calculate differences between adjacent elements
        for (int i = 0; i < n; i++) {
            int nextIndex = (i + 1) % n; // Circular array handling
            int difference = Math.abs(nums[i] - nums[nextIndex]);
            maxDifference = Math.max(maxDifference, difference);
        }

        return maxDifference;
    }
}
