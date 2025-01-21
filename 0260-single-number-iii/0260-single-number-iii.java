class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // XOR all elements together to get the XOR of the two unique numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Find a bit that is set in xor (this bit differs between the two unique numbers)
        int rightmostBit = xor & -xor;

        // Divide the numbers into two groups based on the rightmost bit
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & rightmostBit) == 0) {
                result[0] ^= num; // Group with 0 in the rightmost bit
            } else {
                result[1] ^= num; // Group with 1 in the rightmost bit
            }
        }

        return result;
    }
}
