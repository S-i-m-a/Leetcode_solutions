import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int k, int start) {
        // Base case: If the combination size reaches k, add it to result
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);  // Choose i
            backtrack(result, combination, n, k, i + 1);  // Recur with next number
            combination.remove(combination.size() - 1);  // Backtrack
        }
    }
}
