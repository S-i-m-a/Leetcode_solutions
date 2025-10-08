import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            ans[i] = m - firstIndexSuccess(spells[i], potions, success);
        }
        return ans;
    }
    
    // Return the first index j in potions[] such that (long)spell * potions[j] >= success
    private int firstIndexSuccess(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length;  // search space is [0, potions.length]
        while (l < r) {
            int mid = l + (r - l) / 2;
            long product = (long) spell * potions[mid];
            if (product >= success) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
