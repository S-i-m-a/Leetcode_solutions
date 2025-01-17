class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;

        // Calculate the range for binary search
        for (int num : nums) {
            left = Math.max(left, num); // At least one subarray must have the largest single element
            right += num;              // At most, the sum of the entire array is a valid solution
        }

       
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, m, mid)) {
                right = mid; // Try a smaller maximum sum
            } else {
                left = mid + 1; // Try a larger maximum sum
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int m, int maxSum) {
        int currentSum = 0;
        int subarrays = 1; // Start with one subarray

        for (int num : nums) {
            // If adding this number exceeds maxSum, start a new subarray
            if (currentSum + num > maxSum) {
                currentSum = num;
                subarrays++;
                if (subarrays > m) {
                    return false; // Too many subarrays needed
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}
