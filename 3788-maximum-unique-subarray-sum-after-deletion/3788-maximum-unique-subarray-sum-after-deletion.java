import java.util.Arrays;

class Solution {
    public int maxSum(int[] nums) {
        // Step 1: find the maximum element
        int mx = Arrays.stream(nums).max().getAsInt();
        // If all numbers ≤ 0, return the maximum (non-empty subarray requirement)
        if (mx <= 0) {
            return mx;
        }

        // Step 2: track which positive numbers have been added
        boolean[] seen = new boolean[201]; // nums[i] is between -100 and 100
        int ans = 0;

        // Step 3: sum up each distinct positive number exactly once
        for (int x : nums) {
            if (x > 0 && !seen[x]) {
                seen[x] = true;
                ans += x;
            }
        }

        return ans;
    }
}
