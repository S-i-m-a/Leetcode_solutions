class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Rob houses from index 0 to n-2
        int robFirst = robLinear(nums, 0, nums.length - 2);
        // Rob houses from index 1 to n-1
        int robLast = robLinear(nums, 1, nums.length - 1);
        
        return Math.max(robFirst, robLast);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]
        
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
