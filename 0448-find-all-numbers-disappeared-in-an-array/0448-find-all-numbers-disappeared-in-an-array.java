import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // Step 1: Use the index as a marker for the numbers that have been seen
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1]; // Mark the number as seen by negating the value
            }
        }

        // Step 2: Collect the missing numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // The index i+1 is missing
            }
        }

        return result;
    }
}
