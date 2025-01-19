class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Traverse both strings from the end to the start
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            // Add the current digit of a, if present
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int
            }
            
            // Add the current digit of b, if present
            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // Convert char to int
            }
            
            // Update the carry and the result
            carry = sum / 2;  // Carry will be 1 or 0
            result.append(sum % 2);  // Append the current bit to the result
        }
        
        // The result is built in reverse, so reverse it before returning
        return result.reverse().toString();
    }
}
