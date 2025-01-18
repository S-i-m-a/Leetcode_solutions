import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Edge case: if numerator is 0, the result is simply "0"
        if (numerator == 0) return "0";

        // Result string to store the final fraction representation
        StringBuilder result = new StringBuilder();

        // If the result is negative, append "-" at the beginning
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert both numerator and denominator to long to avoid overflow
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Add the integer part to the result
        result.append(num / denom);
        num %= denom; // Update numerator to remainder after division

        // If there's no remainder, return the result
        if (num == 0) {
            return result.toString();
        }

        // Otherwise, handle the fractional part
        result.append(".");

        // HashMap to store remainders and their corresponding index in the result
        HashMap<Long, Integer> map = new HashMap<>();

        // Loop until we either find a repeating cycle or the remainder is 0
        while (num != 0) {
            // If we've seen this remainder before, it means we're in a cycle
            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            }

            // Store the index of this remainder
            map.put(num, result.length());

            // Perform long division step
            num *= 10;
            result.append(num / denom);
            num %= denom;
        }

        return result.toString();
    }
}
