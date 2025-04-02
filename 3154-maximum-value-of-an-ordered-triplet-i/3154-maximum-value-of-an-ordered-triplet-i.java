public class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;  // Need at least 3 elements

        long maxTriplet = 0;
        int maxLeft = 0;  // Stores max nums[i] seen before j
        
        for (int j = 1; j < n - 1; j++) {
            maxLeft = Math.max(maxLeft, nums[j - 1]); // Update maxLeft
            
            if (maxLeft > nums[j]) { // Ensure nums[i] > nums[j]
                for (int k = j + 1; k < n; k++) {
                    long value = (long) (maxLeft - nums[j]) * nums[k];
                    maxTriplet = Math.max(maxTriplet, value);
                }
            }
        }
        
        return maxTriplet;
    }
}
