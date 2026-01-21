class Solution {
       public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
      
        // Process each number in the input list
        for (int i = 0; i < n; i++) {
            int currentNum = nums.get(i);
          
            // Special case: if the number is 2, no valid answer exists
            if (currentNum == 2) {
                result[i] = -1;
            } else {
                // Find the first 0 bit from left to right (starting from bit position 1)
                for (int bitPosition = 1; bitPosition < 32; bitPosition++) {
                    // Check if the bit at current position is 0
                    if ((currentNum >> bitPosition & 1) == 0) {
                        // XOR with 2^(bitPosition-1) to flip the bit at position (bitPosition-1)
                        // This gives us the minimum value where value | (value + 1) equals currentNum
                        result[i] = currentNum ^ (1 << (bitPosition - 1));
                        break;
                    }
                }
            }
        }
      
        return result;
    }
}