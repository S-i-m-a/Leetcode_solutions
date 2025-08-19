class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long currentCount = 0;  // tracks length of current contiguous zero sequence

        for (int n : nums) {
            if (n == 0) {
                // extend the zero streak and count subarrays ending here
                currentCount++;
                total += currentCount;
            } else {
                // reset on non-zero
                currentCount = 0;
            }
        }

        return total;
    }
}
