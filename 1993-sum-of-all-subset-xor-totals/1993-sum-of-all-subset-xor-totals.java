class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        // Include nums[index]
        int with = dfs(nums, index + 1, currentXor ^ nums[index]);
        // Exclude nums[index]
        int without = dfs(nums, index + 1, currentXor);
        return with + without;
    }
}
