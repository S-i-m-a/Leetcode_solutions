class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        // We repeatedly reduce the array length by 1 until we have one element
        for (int len = n; len > 1; len--) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
