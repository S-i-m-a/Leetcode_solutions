class Solution {
    public boolean isPowerOfFour(int n) {
        // Positive, power of two, and 1-bits only in odd positions (mask 0x55555555)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
