public class Solution {
    public int monotoneIncreasingDigits(int N) {
        // Convert the number into a character array (digits)
        char[] digits = Integer.toString(N).toCharArray();
        
        // The position where the decrease happened
        int mark = digits.length;
        
        // Traverse the digits from right to left to find the first decrease
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                // Mark the position for modification
                mark = i - 1;
                // Decrease the digit before the violation
                digits[mark]--;
            }
        }
        
        // After we mark, change all digits to the right of that position to '9'
        for (int i = mark + 1; i < digits.length; i++) {
            digits[i] = '9';
        }
        
        // Convert the char array back to an integer and return
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int N = 332;
        int result = solution.monotoneIncreasingDigits(N);
        System.out.println(result);  // Output: 299
    }
}
