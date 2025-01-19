class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false; // Numbers less than 1 cannot be perfect squares
        }

        // Binary search to check for a perfect square
        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true; // Found the perfect square
            } else if (square < num) {
                left = mid + 1; // Search for a larger mid
            } else {
                right = mid - 1; // Search for a smaller mid
            }
        }

        return false; // No perfect square found
    }
}
