public class Solution {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        while (N != 0) {
            int remainder = N % (-2);
            N /= (-2);
            
            // Adjust the remainder to be in the range [0, 1]
            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }
            
            result.insert(0, remainder);
        }
        
        return result.toString();
    }
}
