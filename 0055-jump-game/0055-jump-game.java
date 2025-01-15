public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        
        for (int i = 0; i < n; i++) {
            // If we can't reach the current index, return false
            if (i > farthest) {
                return false;
            }
            
            // Update the farthest index we can reach from index i
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we can reach or exceed the last index, return true
            if (farthest >= n - 1) {
                return true;
            }
        }
        
        return false;
    }
}
