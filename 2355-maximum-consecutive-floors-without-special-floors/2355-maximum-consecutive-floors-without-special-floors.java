import java.util.*;

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxGap = special[0] - bottom;  // Consider the gap between bottom and the first special floor
        
        // Calculate gaps between consecutive special floors
        for (int i = 1; i < special.length; i++) {
            maxGap = Math.max(maxGap, special[i] - special[i - 1] - 1);
        }
        
        // Consider the gap between the last special floor and top
        maxGap = Math.max(maxGap, top - special[special.length - 1]);
        
        return maxGap;
    }
}
