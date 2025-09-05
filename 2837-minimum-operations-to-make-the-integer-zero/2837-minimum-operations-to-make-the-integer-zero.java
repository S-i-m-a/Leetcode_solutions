class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try all possible operation counts k from 0 to 60
        for (long k = 0; k <= 60; ++k) {
            long x = num1 - k * (long) num2;
            // x must be non-negative and must satisfy bitCount(x) ≤ k ≤ x
            if (x >= 0 && Long.bitCount(x) <= k && k <= x) {
                return (int) k;
            }
        }
        // If no valid k found, return -1
        return -1;
    }
}
