public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false; // Perfect numbers are positive and greater than 1
        }
        
        int sum = 1; // Start with 1 since it's a divisor of every number
        
        // Loop through possible divisors from 2 to sqrt(num)
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) { // Avoid adding the square root twice
                    sum += num / i;
                }
            }
        }
        
        return sum == num;
    }
}
