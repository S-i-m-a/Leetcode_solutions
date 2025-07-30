class Solution {
    public int longestSubarray(int[] nums) {
        // Step 1: Find the maximum value in the array
        int mx = 0;
        for (int v : nums) {
            mx = Math.max(mx, v);
        }

        // Step 2: Track the longest contiguous sequence of that maximum value
        int ans = 0, cnt = 0;
        for (int v : nums) {
            if (v == mx) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }

        return ans;
    }
}
