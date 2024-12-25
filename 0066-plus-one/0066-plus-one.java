class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the array from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, simply add one and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the digit is 9, it becomes 0 and carry over to the next digit
            digits[i] = 0;
        }
        
        // If all digits were 9, we have a carry that adds a new digit at the beginning
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}
