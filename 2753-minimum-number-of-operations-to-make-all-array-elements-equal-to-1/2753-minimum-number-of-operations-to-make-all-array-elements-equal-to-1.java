public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int v : nums) {
            if (v == 1) ones++;
        }
        if (ones > 0) {
            return n - ones;
        }
        int minOps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minOps = Math.min(minOps, j - i);
                    break;
                }
            }
        }
        if (minOps == Integer.MAX_VALUE) {
            return -1;
        }
        return minOps + n - 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
