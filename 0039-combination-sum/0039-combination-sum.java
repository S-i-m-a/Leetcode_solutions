import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            // If the target is 0, we've found a valid combination
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;  // No need to continue if the candidate exceeds the target
            }
            
            currentCombination.add(candidates[i]);
            // Recurse with the same index i, allowing the same number to be used multiple times
            backtrack(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);  // Backtrack, remove the last added number
        }
    }
}
