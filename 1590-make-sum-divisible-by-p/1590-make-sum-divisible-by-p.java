import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int remainder = (int)(totalSum % p);
        if (remainder == 0) return 0;

        Map<Integer,Integer> prefixIndex = new HashMap<>();
        prefixIndex.put(0, -1);
        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (int)((prefix - remainder + p) % p);
            if (prefixIndex.containsKey(target)) {
                ans = Math.min(ans, i - prefixIndex.get(target));
            }
            prefixIndex.put((int)prefix, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}