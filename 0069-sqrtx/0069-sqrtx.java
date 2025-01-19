class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // The square root of 0 and 1 is the number itself.
        }

        // Binary search to find the square root
        int left = 1, right = x / 2, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // To prevent overflow, use division instead of multiplication
            if (mid <= x / mid) {
                result = mid; // Update result, mid might be the answer
                left = mid + 1; // Try for a larger value
            } else {
                right = mid - 1; // Try for a smaller value
            }
        }

        return result;
    }
}
