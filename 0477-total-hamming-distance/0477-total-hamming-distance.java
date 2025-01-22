public class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int n = nums.length;
        
        // Loop over all 32 bit positions (assuming 32-bit integers)
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            
            // Count how many numbers have the i-th bit set to 1
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    bitCount++;
                }
            }
            
            // The number of differing pairs for the i-th bit
            totalDistance += bitCount * (n - bitCount);
        }
        
        return totalDistance;
    }
}
