class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            // Find an odd number at the left pointer
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            // Find an even number at the right pointer
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            // Swap the odd number on the left with the even number on the right
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }
}
