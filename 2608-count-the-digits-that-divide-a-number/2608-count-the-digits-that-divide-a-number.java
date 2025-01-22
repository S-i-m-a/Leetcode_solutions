public class Solution {
    public int countDigits(int num) {
        int count = 0;
        int original = num; // Store the original number for divisibility check

        // Process each digit of the number
        while (num > 0) {
            int digit = num % 10; // Get the last digit
            num /= 10; // Remove the last digit

            // Check if the digit divides the original number and it's not zero
            if (digit != 0 && original % digit == 0) {
                count++;
            }
        }
        
        return count;
    }
}
