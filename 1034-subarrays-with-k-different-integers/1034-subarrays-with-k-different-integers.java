import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
        return atMost(nums, K) - atMost(nums, K - 1);
    }
    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;
        int distinct = 0;

        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) == 1) {
                distinct++;
            }
            while (distinct > k) {
                int y = nums[left];
                freq.put(y, freq.get(y) - 1);
                if (freq.get(y) == 0) {
                    distinct--;
                }
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}
