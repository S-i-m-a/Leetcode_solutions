class Solution {
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int x : nums) {
            int r = x % 3;
            if (r < 0) r += 3;  // handle possible negative values
            if (r != 0) {
                ops += Math.min(r, 3 - r);
            }
        }
        return ops;
    }
}
