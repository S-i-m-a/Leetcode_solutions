import java.util.*;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        // Map each lake to the last day it rained (i.e. the lake got full)
        Map<Integer, Integer> lastRain = new HashMap<>();
        // A sorted set of dry days (indices i where rains[i] == 0) we can use to dry a lake
        TreeSet<Integer> dryDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                // It rains into lake
                ans[i] = -1;
                if (lastRain.containsKey(lake)) {
                    // We must find a dry day > lastRain.get(lake) and < i to dry it before it rains again
                    Integer dry = dryDays.higher(lastRain.get(lake));
                    if (dry == null) {
                        // No available dry day to avoid flood
                        return new int[0];
                    }
                    // Use that dry day to dry this lake
                    ans[dry] = lake;
                    dryDays.remove(dry);
                }
                // Update lastRain for this lake
                lastRain.put(lake, i);
            } else {
                // It’s a dry day — initially, we can dry any lake; mark with 1 (or arbitrary) for now
                ans[i] = 1;
                dryDays.add(i);
            }
        }
        // For any unused dry day, we can dry arbitrary lake (say 1)
        // The ans array already has 1 in those places by default in the dry day clause above
        
        return ans;
    }
}
