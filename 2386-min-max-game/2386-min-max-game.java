class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int[] temp = new int[nums.length / 2];
            for (int i = 0; i < temp.length; i++) {
                if (i % 2 == 0) {
                    temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = temp; // Update nums to be the new reduced array
        }
        return nums[0]; // Return the final remaining element
    }
}
