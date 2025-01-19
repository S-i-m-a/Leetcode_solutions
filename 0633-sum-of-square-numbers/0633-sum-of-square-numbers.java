class Solution {
    public boolean judgeSquareSum(int c) {
        // Use two pointers approach
        long left = 0;
        long right = (long) Math.sqrt(c); // Largest possible value for 'b'

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true; // Found integers 'a' and 'b'
            } else if (sum < c) {
                left++; // Increase 'a' to make the sum larger
            } else {
                right--; // Decrease 'b' to make the sum smaller
            }
        }

        return false; // No pair found
    }
}
