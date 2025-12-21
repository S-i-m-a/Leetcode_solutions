class Solution {
    public int minDeletionSize(String[] strs) {
        final int n = strs.length;
        int ans = 0;
        // sorted[i] = true if strs[i] < strs[i+1] has been decided
        boolean[] sorted = new boolean[n - 1];

        // Scan columns left to right
        for (int j = 0; j < strs[0].length(); ++j) {
            int i;
            // Check all pairs that are not yet sorted
            for (i = 0; i + 1 < n; ++i) {
                if (!sorted[i] &&
                    strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    // We must delete this column
                    ++ans;
                    break;
                }
            }
            // If we've checked all pairs without breaking,
            // update sorted[] for this column
            if (i + 1 == n) {
                for (i = 0; i + 1 < n; ++i) {
                    if (!sorted[i] &&
                        strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        sorted[i] = true;
                    }
                }
            }
        }
        return ans;
    }
}
