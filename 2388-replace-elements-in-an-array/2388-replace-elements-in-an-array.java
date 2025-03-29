import java.util.*;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Map each number to its index
        for (int i = 0; i < nums.length; i++)
            indexMap.put(nums[i], i);

        // Perform replacements
        for (int[] op : operations) {
            int index = indexMap.get(op[0]);
            nums[index] = op[1];
            indexMap.remove(op[0]);
            indexMap.put(op[1], index);
        }

        return nums;
    }
}
