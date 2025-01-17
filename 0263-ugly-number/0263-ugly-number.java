class Solution {
    public boolean isUgly(int n) {
        // Handle edge case
        if (n <= 0) return false;
        
        // Divide the number by 2, 3, or 5 while divisible
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        
        // If the remaining number is 1, it is an ugly number
        return n == 1;
    }
}
