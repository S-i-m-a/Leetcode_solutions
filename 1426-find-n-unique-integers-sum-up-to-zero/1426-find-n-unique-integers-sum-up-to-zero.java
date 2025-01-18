import java.util.*;

public class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        
        // Fill the result array with pairs of positive and negative integers
        for (int i = 0; i < n / 2; i++) {
            result[i] = i + 1;          // Positive numbers
            result[n - i - 1] = -(i + 1);  // Corresponding negative numbers
        }
        
        // If n is odd, place 0 in the middle
        if (n % 2 != 0) {
            result[n / 2] = 0;
        }
        
        return result;
    }
}
