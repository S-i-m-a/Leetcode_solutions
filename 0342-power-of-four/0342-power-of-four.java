class Solution {
    public boolean isPowerOfFour(int n) {
        // Check if n is a power of two and has 1s only in odd positions
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
