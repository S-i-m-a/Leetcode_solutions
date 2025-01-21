class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false; // Power of three must be positive
        while (n % 3 == 0) {
            n /= 3; // Divide n by 3
        }
        return n == 1; // Check if n reduced to 1
    }
}
