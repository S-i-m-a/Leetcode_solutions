class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int prevLen = 0;     // length of the previous strictly increasing run
        int curLen = 1;      // length of the current strictly increasing run (at least 1)

        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                // continuing the strictly increasing run
                curLen++;
            } else {
                // the run breaks here (i.e., nums[i] <= nums[i-1])
                // evaluate possible k’s at this boundary
                ans = Math.max(ans, curLen / 2);
                ans = Math.max(ans, Math.min(prevLen, curLen));

                // shift current to previous, reset current
                prevLen = curLen;
                curLen = 1;
            }
        }
        // also consider the last run (because the loop ends without a “break” event)
        ans = Math.max(ans, curLen / 2);
        ans = Math.max(ans, Math.min(prevLen, curLen));

        return ans;
    }
}
