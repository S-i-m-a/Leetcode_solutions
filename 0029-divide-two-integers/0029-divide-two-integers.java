class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case where result would overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Calculate sign of the result
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        
        // Work with absolute values to simplify the division logic
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        long quotient = 0;
        
        // Perform division using bitwise shifts
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            
            // Double the divisor and count how many times we can subtract
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the large chunk from the dividend
            absDividend -= tempDivisor;
            quotient += multiple;
        }
        
        // Apply the sign to the result and return
        return (int) (sign * quotient);
    }
}
