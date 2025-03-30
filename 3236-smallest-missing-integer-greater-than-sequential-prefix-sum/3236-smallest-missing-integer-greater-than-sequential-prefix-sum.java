import java.util.HashSet;

public class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int prefixSum = nums[0];
        
        // Continue adding while the next number is consecutive (diff of 1)
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                prefixSum += nums[i];
            } else {
                break;
            }
        }

        // Create a set for fast lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Find the smallest missing integer >= prefixSum
        while (set.contains(prefixSum)) {
            prefixSum++;
        }

        return prefixSum;
    }
}
