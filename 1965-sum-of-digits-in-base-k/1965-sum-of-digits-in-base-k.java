public class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        
        // Repeat until n becomes 0
        while (n > 0) {
            sum += n % k; // Add the remainder (digit) to sum
            n /= k; // Divide n by k to get the next digit
        }
        
        return sum;
    }
}
