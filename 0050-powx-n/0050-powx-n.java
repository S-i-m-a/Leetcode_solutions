class Solution {
    public double myPow(double x, int n) {
        // Handle edge case of n = Integer.MIN_VALUE
        if (n == Integer.MIN_VALUE) {
            if (x == 1 || x == -1) {
                return 1; // Special case for base 1 and -1
            }
            return 0; // For all other bases
        }
        
        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (n > 0) {
            // If n is odd, multiply result by currentProduct
            if ((n % 2) == 1) {
                result *= currentProduct;
            }
            // Square the base and reduce n by half
            currentProduct *= currentProduct;
            n /= 2;
        }
        
        return result;
    }
}
