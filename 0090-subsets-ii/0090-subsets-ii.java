import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));  // Add the current subset to the result
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: if the current number is the same as the previous one, skip it
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);  // Include the current element
            backtrack(nums, i + 1, current, result);  // Explore the next elements
            current.remove(current.size() - 1);  // Backtrack
        }
    }
}
