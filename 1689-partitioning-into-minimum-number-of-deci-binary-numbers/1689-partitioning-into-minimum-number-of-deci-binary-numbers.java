class Solution {
    /**
     * Finds the minimum number of positive deci-binary numbers needed to sum up to n.
     * A deci-binary number is a decimal number where each digit is either 0 or 1.
     * 
     * The key insight: The minimum number of deci-binary numbers needed equals 
     * the maximum digit in the input string n.
     * 
     * @param n A string representing a non-negative integer
     * @return The minimum number of positive deci-binary numbers whose sum equals n
     */
    public int minPartitions(String n) {
        // Initialize the maximum digit found so far
        int maxDigit = 0;
      
        // Iterate through each character in the string
        for (int i = 0; i < n.length(); i++) {
            // Convert character to its numeric value
            int currentDigit = n.charAt(i) - '0';
          
            // Update the maximum digit if current digit is larger
            maxDigit = Math.max(maxDigit, currentDigit);
        }
      
        // Return the maximum digit as the minimum number of partitions
        return maxDigit;
    }
}