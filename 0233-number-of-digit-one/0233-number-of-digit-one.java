public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1; // Factor for current digit (1s, 10s, 100s, etc.)
        
        while (n / factor > 0) {
            long lower = n % factor; // Digits below the current digit
            long current = (n / factor) % 10; // Current digit
            long higher = n / (factor * 10); // Digits above the current digit
            
            if (current == 0) {
                count += higher * factor; // Only contributions from higher digits
            } else if (current == 1) {
                count += higher * factor + lower + 1; // Include lower digits and the current digit
            } else {
                count += (higher + 1) * factor; // Contributions from all higher digits
            }
            
            factor *= 10; // Move to the next digit
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13;
        System.out.println("Number of digit one from 1 to " + n + ": " + solution.countDigitOne(n));
    }
}
