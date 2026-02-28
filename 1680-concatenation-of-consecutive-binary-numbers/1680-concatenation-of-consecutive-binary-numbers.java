class Solution {
    public int concatenatedBinary(int n) {
        // Define modulo constant for preventing integer overflow
        final int MOD = 1000000007;
      
        // Initialize result variable to store the concatenated binary value
        long result = 0;
      
        // Iterate through each number from 1 to n
        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
        
            int bitsRequired = 32 - Integer.numberOfLeadingZeros(currentNumber);
          

            result = ((result << bitsRequired) | currentNumber) % MOD;
        }
      
        // Cast and return the final result as an integer
        return (int) result;
    }
}