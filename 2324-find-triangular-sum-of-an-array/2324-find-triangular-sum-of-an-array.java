class Solution {
    public int triangularSum(int[] nums) {
        // Repeat until only one element remains in the array
        while (nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                // Update nums[i] with the sum of nums[i] and nums[i+1] modulo 10
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            // Shorten the array (by one element)
            nums = Arrays.copyOf(nums, nums.length - 1);
        }
        // The final element is the triangular sum
        return nums[0];
    }
}
