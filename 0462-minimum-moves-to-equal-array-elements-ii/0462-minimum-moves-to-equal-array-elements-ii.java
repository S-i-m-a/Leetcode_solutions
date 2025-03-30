import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2], res = 0;
        for (int n : nums) res += Math.abs(n - mid);
        return res;
    }
}
