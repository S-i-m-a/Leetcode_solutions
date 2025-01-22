public class Solution {
    public int dominantIndex(int[] nums) {
        // Find the maximum number and its index
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        
        // Check if the largest value is at least twice as large as all other values
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && maxVal < 2 * nums[i]) {
                return -1; // If the largest value is less than twice of any other, return -1
            }
        }
        
        return maxIndex; // If the condition holds, return the index of the largest value
    }
}
