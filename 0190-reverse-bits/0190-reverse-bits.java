public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            // Shift result to the left to make space
            result <<= 1;
            // Add the last bit of n to result
            result |= (n & 1);
            // Shift n to the right to process next bit
            n >>= 1;
        }
        
        return result;
    }
}
