import java.util.HashSet;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
