class Solution {
    public String removeDigit(String number, char digit) {
        int lastIndexOccurrence = -1; // Initialize the last index of the digit to be removed
        int stringLength = number.length(); // Get the length of the number string

        // Iterate through each character of the string
        for (int i = 0; i < stringLength; ++i) {
            char currentDigit = number.charAt(i); // Get the character at the current index
          
            // Check if the current character matches the digit we want to remove
            if (currentDigit == digit) {
                lastIndexOccurrence = i; // Update the last index occurrence of the digit
              
                // If the digit to remove is smaller than the next digit,
                // and there is a next digit, break the loop
                if (i + 1 < stringLength && currentDigit < number.charAt(i + 1)) {
                    break;
                }
            }
        }
      
        // Remove the digit at the last index occurrence and return the new string
        return number.substring(0, lastIndexOccurrence) + number.substring(lastIndexOccurrence + 1);
    }
}