import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // count the original frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        // difference-map (sweep line) for marking ranges [x-k, x+k]
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            // mark x as a key in diff (so that position x appears even if no delta)
            diff.putIfAbsent(x, 0);
            // start of range where this x can be target: x-k
            diff.merge(x - k, 1, Integer::sum);
            // end of range (exclusive): x + k + 1
            diff.merge(x + k + 1, -1, Integer::sum);
        }
        
        int maxFreq = 0;
        int running = 0;  // number of elements that *can* reach current target value
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int val = entry.getKey();
            int delta = entry.getValue();
            running += delta;
            // how many of the original nums equal this value?
            int originals = freq.getOrDefault(val, 0);
            // we can use at most numOperations to convert other numbers
            // so achievable frequency at value 'val' = min(running, originals + numOperations)
            int achievable = Math.min(running, originals + numOperations);
            maxFreq = Math.max(maxFreq, achievable);
        }
        
        return maxFreq;
    }
}
