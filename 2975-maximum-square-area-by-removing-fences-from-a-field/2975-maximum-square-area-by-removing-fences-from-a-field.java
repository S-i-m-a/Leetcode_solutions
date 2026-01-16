import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Add boundary fences
        int[] hAll = Arrays.copyOf(hFences, hFences.length + 2);
        hAll[hFences.length] = 1;
        hAll[hFences.length + 1] = m;
        int[] vAll = Arrays.copyOf(vFences, vFences.length + 2);
        vAll[vFences.length] = 1;
        vAll[vFences.length + 1] = n;
        
        // Sort both arrays
        Arrays.sort(hAll);
        Arrays.sort(vAll);

        // Compute all horizontal gaps
        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < hAll.length; i++) {
            for (int j = 0; j < i; j++) {
                hGaps.add(hAll[i] - hAll[j]);
            }
        }

        // Compute vertical gaps and track the largest common side
        int maxSide = -1;
        for (int i = 0; i < vAll.length; i++) {
            for (int j = 0; j < i; j++) {
                int gap = vAll[i] - vAll[j];
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        // If no common square side found
        if (maxSide <= 0) {
            return -1;
        }

        // Return area modulo 10^9+7
        long mod = 1_000_000_007L;
        return (int)((maxSide * 1L * maxSide) % mod);
    }
}
