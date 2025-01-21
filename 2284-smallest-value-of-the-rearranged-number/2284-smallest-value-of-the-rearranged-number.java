import java.util.Arrays;

class Solution {
    public long smallestNumber(long n) {
        // If the number is negative, rearrange digits in descending order
        if (n < 0) {
            // Convert the negative number to a positive one for easier manipulation
            char[] digits = String.valueOf(-n).toCharArray();
            Arrays.sort(digits); // Sort digits in ascending order

            // Rearrange digits in descending order to form the smallest possible negative number
            StringBuilder sb = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }

            // Return the result as a negative number
            return -Long.parseLong(sb.toString());
        } else {
            // For positive numbers, rearrange digits in ascending order
            char[] digits = String.valueOf(n).toCharArray();
            Arrays.sort(digits); // Sort digits in ascending order

            // If the first digit is '0', find the first non-zero digit and place it at the start
            if (digits[0] == '0') {
                for (int i = 1; i < digits.length; i++) {
                    if (digits[i] != '0') {
                        // Swap the first non-zero digit to the front
                        char temp = digits[i];
                        digits[i] = digits[0];
                        digits[0] = temp;
                        break;
                    }
                }
            }

            // Convert the digits back to a long
            return Long.parseLong(new String(digits));
        }
    }
}
