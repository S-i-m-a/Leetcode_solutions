import java.util.*;

public class Solution {
    private long[] memo;
    private int n;
    private int[] distinct;       // sorted distinct damage values
    private long[] takeValue;     // takeValue[i] = distinct[i] * freq(distinct[i])
    private int[] nextIndex;      // nextIndex[i] = first index j > i s.t. distinct[j] > distinct[i] + 2

    public long maximumTotalDamage(int[] power) {
        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        // Build sorted distinct list
        List<Integer> ds = new ArrayList<>(freq.keySet());
        Collections.sort(ds);
        n = ds.size();
        distinct = new int[n];
        takeValue = new long[n];
        for (int i = 0; i < n; i++) {
            distinct[i] = ds.get(i);
            takeValue[i] = (long) distinct[i] * freq.get(distinct[i]);
        }

        // Build nextIndex array via binary search
        nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int target = distinct[i] + 2;
            // find first j > i such that distinct[j] > target
            int lo = i + 1, hi = n;  // hi = n means “out of bounds”
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (distinct[mid] > target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            nextIndex[i] = lo;
        }

        // Memo for recursion
        memo = new long[n];
        Arrays.fill(memo, -1L);

        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (memo[i] != -1L) {
            return memo[i];
        }
        // Option 1: skip
        long ans = dfs(i + 1);
        // Option 2: take at i
        long take = takeValue[i] + dfs(nextIndex[i]);
        ans = Math.max(ans, take);
        memo[i] = ans;
        return ans;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumTotalDamage(new int[]{1,1,3,4}));       // expect 6
        System.out.println(sol.maximumTotalDamage(new int[]{7,1,6,6}));       // expect 13
    }
}
