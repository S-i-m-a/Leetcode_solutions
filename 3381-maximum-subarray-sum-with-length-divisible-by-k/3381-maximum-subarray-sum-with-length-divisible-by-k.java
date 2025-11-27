class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0;
        long ans = Long.MIN_VALUE;

        // minPrefix[r] = minimum prefix sum seen so far at indices i where i % k == r
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 2);
        // To handle subarrays starting from index 0:
        // we consider prefix sum before any element as 0 at “index” -1 => (-1 % k) == (k-1)
        minPrefix[(k - 1) % k] = 0;

        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            int r = i % k;
            // subarray ending at i with length divisible by k: use min prefix sum from same modulo class
            ans = Math.max(ans, prefix - minPrefix[r]);
            // update min prefix for this modulo class
            minPrefix[r] = Math.min(minPrefix[r], prefix);
        }

        return ans;
    }
}
