class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int last = 0;  // index of the last seen number that differs from current

        for (int i = 1; i + 1 < nums.length; i++) {
            // skip flat plateaus by checking if current equals next
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            // check hill or valley compared to closest non-equal neighbor on left and current next
            if ((nums[i] > nums[last] && nums[i] > nums[i + 1]) ||
                (nums[i] < nums[last] && nums[i] < nums[i + 1])) {
                count++;
            }
            last = i;
        }

        return count;
    }
}
