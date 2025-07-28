class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        // Using an array to allow modification inside recursion
        int[] count = new int[1];
        dfs(nums, 0, 0, maxOr, count);
        return count[0];
    }

    private void dfs(int[] nums, int index, int currentOr, int maxOr, int[] count) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count[0]++;
            }
            return;
        }
        // Option 1: skip current element
        dfs(nums, index + 1, currentOr, maxOr, count);
        // Option 2: include current element
        dfs(nums, index + 1, currentOr | nums[index], maxOr, count);
    }
}
