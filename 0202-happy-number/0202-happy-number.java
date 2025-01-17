import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            if (seen.contains(n)) {
                return false; // If the number is already seen, a cycle is detected
            }
            seen.add(n);
            n = sumOfSquares(n); // Get the sum of squares of digits
        }
        
        return true; // If we reach 1, it's a happy number
    }

    // Helper function to calculate the sum of squares of digits
    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
