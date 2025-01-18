public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the max reachable index, return false
            if (i > maxReach) {
                return false;
            }
            
            // Update maxReach to the farthest index we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If maxReach is already beyond or at the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}
