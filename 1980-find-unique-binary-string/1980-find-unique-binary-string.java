class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // Bitmask to track which counts of '1's exist in the input strings
        // If bit i is set, it means there exists a string with i ones
        int existingOnesCounts = 0;
      
        // Count the number of '1's in each binary string
        for (String binaryString : nums) {
            int onesCount = 0;
          
            // Count '1's in current binary string
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    onesCount++;
                }
            }
          
            // Mark this count as existing by setting the corresponding bit
            existingOnesCounts |= (1 << onesCount);
        }
      
        // Find the first count that doesn't exist
        for (int targetOnesCount = 0; ; targetOnesCount++) {
            // Check if this count is missing (bit is 0)
            if ((existingOnesCounts >> targetOnesCount & 1) == 0) {
                // Construct a binary string with targetOnesCount ones followed by zeros
                // This guarantees a different string since no input has this exact count of ones
                return "1".repeat(targetOnesCount) + "0".repeat(nums.length - targetOnesCount);
            }
        }
    }
}