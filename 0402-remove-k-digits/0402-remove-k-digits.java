public class Solution {
    public String removeKdigits(String num, int k) {
        // Stack to store the digits
        StringBuilder stack = new StringBuilder();
        
        // Iterate through each digit of the number
        for (char digit : num.toCharArray()) {
            // If we can remove digits and the current digit is smaller than the top of the stack
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);  // Remove the top element
                k--;  // Decrease the number of digits to remove
            }
            stack.append(digit);  // Add the current digit to the stack
        }
        
        // If we haven't removed enough digits, remove from the end of the stack
        stack.setLength(stack.length() - k);
        
        // Convert the stack to a string
        String result = stack.toString();
        
        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        result = result.substring(startIndex);
        
        // If the result is empty, return "0"
        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String num = "1432219";
        int k = 3;
        
        String result = solution.removeKdigits(num, k);
        System.out.println(result);  // Output: "1219"
    }
}
