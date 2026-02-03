class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        // 1. Strictly increasing from start
        while (i < n - 2 && nums[i] < nums[i+1]) {
            i++;
        }
        // Must have at least one increasing step
        if (i == 0) return false;

        // `i` now is p: end of the first increasing part

        // 2. Strictly decreasing
        int j = i;
        while (j < n - 1 && nums[j] > nums[j+1]) {
            j++;
        }
        // Must have at least one decreasing step and room for final increase
        if (j == i || j == n - 1) return false;

        // `j` now is q: end of the decreasing segment

        // 3. Strictly increasing to the end
        while (j < n - 1 && nums[j] < nums[j+1]) {
            j++;
        }

        // If we reached the end, it's trionic
        return j == n - 1;
    }
}
