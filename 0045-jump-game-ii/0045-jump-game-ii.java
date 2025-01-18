public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;  // No jump needed if the array has only one element.
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Update the farthest point we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;  // Make a jump
                currentEnd = farthest;  // Update the range to the farthest point we can reach

                // If the current end is already beyond or at the last index, return the jump count
                if (currentEnd >= nums.length - 1) {
                    return jumps;
                }
            }
        }

        return -1;  // In case no solution is found, although this should not happen with valid input
    }
}
