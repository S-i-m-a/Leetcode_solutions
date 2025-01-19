class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Initial base index to calculate lengths
        
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);  // Push the index of '('
            } else {
                stack.pop();  // Pop the top element for matching ')'
                
                if (stack.isEmpty()) {
                    stack.push(i);  // If the stack is empty, push the current index
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
