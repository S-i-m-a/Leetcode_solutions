import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for calculating lengths
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Store index of '('
            } else {
                stack.pop(); // Try to match with previous '('
                if (stack.isEmpty()) {
                    stack.push(i); // Update base index for next valid substring
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek()); // Update max length
                }
            }
        }

        return maxLength;
    }
}
