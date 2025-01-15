public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        // Edge case: if there is only one element, no jump is needed.
        if (n == 1) return 0;
        
        int jumps = 0;          // The number of jumps made so far
        int current_end = 0;    // The farthest index that can be reached with the current number of jumps
        int farthest = 0;       // The farthest index that can be reached with the next jump
        
        for (int i = 0; i < n; i++) {
            // Update the farthest point that can be reached from index i
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we reach the end of the current jump range
            if (i == current_end) {
                jumps++; // We need to make another jump
                current_end = farthest; // Update the end of the current jump range
                
                // If the current_end reaches or exceeds the last index, we're done
                if (current_end >= n - 1) break;
            }
        }
        
        return jumps;
    }
}
