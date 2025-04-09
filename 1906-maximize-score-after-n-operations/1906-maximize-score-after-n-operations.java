import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> memo = new HashMap<>();
        return backtrack(nums, 0, 1, memo);
    }

    private int backtrack(int[] nums, int mask, int operation, Map<Integer, Integer> memo) {
        if (operation > nums.length / 2) {
            return 0;
        }
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0) {
                    continue;
                }
                int newMask = mask | (1 << i) | (1 << j);
                int currentScore = operation * gcd(nums[i], nums[j]);
                int remainingScore = backtrack(nums, newMask, operation + 1, memo);
                maxScore = Math.max(maxScore, currentScore + remainingScore);
            }
        }
        memo.put(mask, maxScore);
        return maxScore;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
