class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        int ans = 0;
        int leftSum = 0;
        for (int x : nums) {
            if (x == 0) {
                if (leftSum * 2 == total) {
                    ans += 2;
                } else if (Math.abs(leftSum * 2 - total) == 1) {
                    ans += 1;
                }
            }
            leftSum += x;
        }
        return ans;
    }
}
