import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        // Use StringBuilder for efficient appends / inserts
        StringBuilder result = new StringBuilder();
        
        // Determine the sign
        // If numerator and denominator have opposite signs, result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert to positive long to avoid overflow (especially for Integer.MIN_VALUE)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Append integer part (quotient)
        long integerPart = num / den;
        result.append(integerPart);
        
        // Remainder after integer division
        long remainder = num % den;
        if (remainder == 0) {
            // No fractional part
            return result.toString();
        }
        
        // There is a fractional part
        result.append(".");
        
        // Map to store remainder → index in result (where that remainder first appeared)
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        
        // Loop until remainder becomes 0 or we detect a repeating cycle
        while (remainder != 0) {
            // If this remainder has appeared before, it's a repeating cycle
            if (remainderIndexMap.containsKey(remainder)) {
                int idx = remainderIndexMap.get(remainder);
                result.insert(idx, "(");
                result.append(")");
                break;
            }
            
            // Store the current remainder with its corresponding position in the result
            remainderIndexMap.put(remainder, result.length());
            
            // Multiply remainder by 10, get the next digit
            remainder *= 10;
            long digit = remainder / den;
            result.append(digit);
            
            // Update remainder
            remainder = remainder % den;
        }
        
        return result.toString();
    }
    
    // For quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fractionToDecimal(1, 2));   // "0.5"
        System.out.println(sol.fractionToDecimal(2, 1));   // "2"
        System.out.println(sol.fractionToDecimal(2, 3));   // "0.(6)"
        System.out.println(sol.fractionToDecimal(4, 333)); // "0.(012)"
        System.out.println(sol.fractionToDecimal(-50, 8)); // "-6.25"
        System.out.println(sol.fractionToDecimal(1, 6));   // "0.1(6)"
    }
}
