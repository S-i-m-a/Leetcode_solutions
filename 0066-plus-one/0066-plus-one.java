class Solution {
    /**
     * Adds one to a number represented as an array of digits.
     * Each element in the array represents a single digit (0-9).
     * The most significant digit is at the head of the array.
     * 
     * @param digits Array representing a non-negative integer
     * @return Array representing the integer plus one
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
      
        // Traverse the array from right to left (least significant to most significant digit)
        for (int i = length - 1; i >= 0; i--) {
            // Add 1 to the current digit
            digits[i]++;
          
            // Handle carry by taking modulo 10
            digits[i] = digits[i] % 10;
          
            // If the current digit is not 0, no carry is needed, return the result
            if (digits[i] != 0) {
                return digits;
            }
            // If digit becomes 0, continue to next iteration to handle carry
        }
      
        // If we reach here, all digits were 9 (e.g., 999 becomes 1000)
        // Create a new array with one extra digit
        int[] result = new int[length + 1];
        result[0] = 1;  // Set the most significant digit to 1
        // All other positions remain 0 by default
      
        return result;
    }
}
