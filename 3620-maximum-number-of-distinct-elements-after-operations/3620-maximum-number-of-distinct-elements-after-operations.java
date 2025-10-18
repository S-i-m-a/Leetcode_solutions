class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 0;
        // the value of the last assigned distinct value
        long prev = Long.MIN_VALUE;  // use long to avoid overflow when adjusting

        for (int x : nums) {
            // each element x can be adjusted into the interval [x − k, x + k]
            long low  = (long)x - k;
            long high = (long)x + k;

            // We want to pick the smallest possible value ≥ (prev + 1) to ensure distinctness,
            // but still within [low, high]
            long assign = Math.max(low, prev + 1);
            if (assign <= high) {
                // We can assign a new distinct value
                ans++;
                prev = assign;
            }
            // else: cannot get a distinct value for this x because the allowed interval
            // is completely ≤ prev, so skip
        }

        return ans;
    }
}
