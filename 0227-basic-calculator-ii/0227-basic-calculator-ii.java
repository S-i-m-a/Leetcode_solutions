import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operator = '+';
        s = s.replace(" ", "");
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(currentNumber);
                } else if (operator == '-') {
                    stack.push(-currentNumber);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operator = c;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
