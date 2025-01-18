public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        // Loop through all 32 bits
        while (n != 0) {
            count += (n & 1); // If the least significant bit is 1, increment count
            n >>>= 1;          // Unsigned right shift to process the next bit
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int input = 43261596; // Binary: 00000010100101000001111010011100
        int result = solution.hammingWeight(input);
        System.out.println(result);  // Output: 9
        
        // Test case 2: Handle large unsigned integer (4294967293)
        long inputLong = 4294967293L; // Use long to store large unsigned integer
        int resultLong = solution.hammingWeight((int) inputLong); // Cast to int for processing
        System.out.println(resultLong);  // Output: 31
    }
}
