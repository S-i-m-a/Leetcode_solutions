import java.util.*;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int k = n / 3;
        
        // Memoization map: key = i * 501 * 17 + j * 17 + k (custom encoding)
        Map<String, Integer> memo = new HashMap<>();
        
        return Math.max(dp(slices, 0, n - 1, k, memo), 
                        dp(slices, 1, n, k, memo));
    }
    
    private int dp(int[] slices, int i, int j, int k, Map<String, Integer> memo) {
        if (k == 1) {
            int max = Integer.MIN_VALUE;
            for (int p = i; p < j; p++) {
                max = Math.max(max, slices[p]);
            }
            return max;
        }
        
        if (j - i < 2 * k - 1) {
            return Integer.MIN_VALUE;
        }
        
        String key = i + "," + j + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int take = slices[i] + dp(slices, i + 2, j, k - 1, memo);
        int skip = dp(slices, i + 1, j, k, memo);
        
        int ans = Math.max(take, skip);
        memo.put(key, ans);
        
        return ans;
    }
}
