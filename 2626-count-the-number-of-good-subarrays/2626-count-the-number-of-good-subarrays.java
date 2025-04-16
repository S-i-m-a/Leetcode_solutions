import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 10;
        System.out.println(countGood(nums, k));  // Output: 1
    }

    public static long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long pairs = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            pairs += count;
            freq.put(val, count + 1);

            while (pairs >= k) {
                result += nums.length - right;
                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                pairs -= leftCount - 1;
                freq.put(leftVal, leftCount - 1);
                left++;
            }
        }

        return result;
    }
}
