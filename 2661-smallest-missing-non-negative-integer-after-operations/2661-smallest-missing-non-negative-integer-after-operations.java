import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // Count how many numbers map to each remainder modulo `value`
        // We normalize negative remainders to [0, value-1]
        int[] cnt = new int[value];
        for (int x : nums) {
            int r = x % value;
            if (r < 0) {
                r += value;
            }
            cnt[r]++;
        }

        // Now we try to build integers 0, 1, 2, 3, … in order.
        // For an integer i, we need one number whose remainder is i % value.
        for (int i = 0; ; i++) {
            int r = i % value;
            if (cnt[r] == 0) {
                return i;
            }
            cnt[r]--;
        }
    }
}
