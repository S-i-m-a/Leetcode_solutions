import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int n = A.length;
        
        // Traverse the array A from the last element to the first
        int carry = K;
        
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + carry % 10;  // Add the current digit from A and the current digit of K
            carry = (carry / 10) + (sum / 10);  // Update carry
            result.add(sum % 10);  // Store the result digit
        }

        // If there's any remaining carry, process the remaining digits of K
        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        
        // Reverse the result because we added digits from least significant to most significant
        Collections.reverse(result);
        
        return result;
    }
}
