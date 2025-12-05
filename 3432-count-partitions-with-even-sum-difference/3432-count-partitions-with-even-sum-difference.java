class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        long total = 0;
        for (int x : nums) {
            total += x;
        }
        // If total sum is odd, no partition gives even difference
        if (total % 2 != 0) {
            return 0;
        }
        // Otherwise, any partition index from 0 to n-2 is valid
        return n - 1;
    }
}
