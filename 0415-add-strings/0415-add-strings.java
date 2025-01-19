class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        // Traverse both strings from the end to the start
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            // Add the current digit of num1, if present
            if (i >= 0) {
                sum += num1.charAt(i--) - '0'; // Convert char to int
            }
            
            // Add the current digit of num2, if present
            if (j >= 0) {
                sum += num2.charAt(j--) - '0'; // Convert char to int
            }
            
            // Update the carry and the result
            carry = sum / 10;  // Carry will be 1 or 0
            result.append(sum % 10);  // Append the current digit to the result
        }
        
        // The result is built in reverse, so reverse it before returning
        return result.reverse().toString();
    }
}
