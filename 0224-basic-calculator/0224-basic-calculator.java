import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int sign = 1; // 1 represents positive, -1 represents negative
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } 
            else if (c == '+') {
                result += sign * currentNumber;
                sign = 1;
                currentNumber = 0;
            } 
            else if (c == '-') {
                result += sign * currentNumber;
                sign = -1;
                currentNumber = 0;
            } 
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (c == ')') {
                result += sign * currentNumber;
                currentNumber = 0;
                result *= stack.pop(); // Pop the sign before '('
                result += stack.pop(); // Pop the result before '('
            }
        }

        if (currentNumber != 0) {
            result += sign * currentNumber;
        }

        return result;
    }
}
