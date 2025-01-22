public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;  // XOR to find differing bits
        int distance = 0;
        
        // Count the number of 1s in the XOR result (Hamming distance)
        while (xor != 0) {
            distance += xor & 1;  // Add 1 if the last bit is 1
            xor >>= 1;  // Right shift xor by 1 to check the next bit
        }
        
        return distance;
    }
}
