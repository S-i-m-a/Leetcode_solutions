public class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        
        for (int num = low; num <= high; num++) {
            // Convert the number to string to easily access digits
            String numStr = String.valueOf(num);
            
            // Check if the number has an even number of digits
            if (numStr.length() % 2 == 0) {
                int mid = numStr.length() / 2;
                int sum1 = 0;
                int sum2 = 0;
                
                // Sum the first half and second half digits
                for (int i = 0; i < mid; i++) {
                    sum1 += numStr.charAt(i) - '0'; // First half sum
                    sum2 += numStr.charAt(mid + i) - '0'; // Second half sum
                }
                
                // If both sums are equal, it's a symmetric integer
                if (sum1 == sum2) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
