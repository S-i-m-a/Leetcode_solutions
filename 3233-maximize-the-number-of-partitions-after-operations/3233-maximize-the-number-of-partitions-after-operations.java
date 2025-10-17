import java.util.*;

public class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        // memo key: (i, canChange, mask) compressed into a long
        Map<Long, Integer> memo = new HashMap<>();
        // dp returns number of partitions in s[i..end), excluding the “+1 for first partition” trick
        int res = dp(s, 0, true, 0, k, memo);
        // +1 because the DP formulation counts partitions *after* the first split
        return res + 1;
    }
    
    private int dp(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> memo) {
        int n = s.length();
        if (i == n) {
            return 0;
        }
        // encode state into a key
        long key = (((long)i) << 35)  // i in high bits
                   | ((canChange ? 1L : 0L) << 34)
                   | (mask & ((1 << 26) - 1));
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int best = 0;
        // Option 1: do not change s[i]
        int bit = 1 << (s.charAt(i) - 'a');
        best = Math.max(best, helper(s, i, canChange, mask, bit, k, memo));
        
        // Option 2: if allowed, change s[i] to any letter 'a'..'z'
        if (canChange) {
            for (int c = 0; c < 26; c++) {
                int newBit = 1 << c;
                // skip if same as original to avoid redundant
                if (newBit == bit) continue;
                best = Math.max(best,
                                helper(s, i, false, mask, newBit, k, memo));
            }
        }
        
        memo.put(key, best);
        return best;
    }
    
    // helper: consider consuming s[i] with one chosen bit (from either original or changed char)
    private int helper(String s, int i, boolean nextCanChange, int mask, int newBit,
                       int k, Map<Long, Integer> memo) {
        int newMask = mask | newBit;
        // if adding this newBit causes the count of distinct letters to exceed k,
        // then we must start a new partition at i: count +1, and reset mask to this newBit alone
        if (Integer.bitCount(newMask) > k) {
            // we break a partition before this character, so this character starts a new partition
            // hence +1, and mask resets to newBit
            return 1 + dp(s, i + 1, nextCanChange, newBit, k, memo);
        } else {
            // we can continue in the same partition
            return dp(s, i + 1, nextCanChange, newMask, k, memo);
        }
    }
}
