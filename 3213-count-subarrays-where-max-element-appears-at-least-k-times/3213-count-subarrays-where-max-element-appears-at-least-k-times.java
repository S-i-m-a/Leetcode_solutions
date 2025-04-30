import java.util.Arrays;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == maxNum) {
                count++;
            }

            while (count == k) {
                if (nums[left] == maxNum) {
                    count--;
                }
                left++;
            }

            ans += left;
        }

        return ans;
    }
}
