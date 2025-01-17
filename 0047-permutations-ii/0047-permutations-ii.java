import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to handle duplicates
        backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Found a valid permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(nums, result, tempList, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }
}
