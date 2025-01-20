class Solution {
    public int findIntegers(int n) {
        // Convert n to binary and get its length
        String binary = Integer.toBinaryString(n);
        int length = binary.length();
        
        // Fibonacci array to store the count of valid numbers of length i
        int[] fib = new int[length + 1];
        fib[0] = 1; // 1 bit: only "0"
        fib[1] = 2; // 2 bits: "0", "1"
        
        for (int i = 2; i <= length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        int count = 0;
        int prevBit = 0; // Tracks the previous bit (0 or 1)
        
        // Traverse the binary representation of n
        for (int i = 0; i < length; i++) {
            int currentBit = binary.charAt(i) - '0';
            
            // If the current bit is 1, add the valid numbers of length (remaining bits)
            if (currentBit == 1) {
                count += fib[length - i - 1];
                // If the previous bit was also 1, we stop early (invalid due to consecutive 1s)
                if (prevBit == 1) {
                    return count;
                }
            }
            
            // Update the previous bit
            prevBit = currentBit;
        }
        
        // Include the number n itself if it has no consecutive 1s
        return count + 1;
    }
}
