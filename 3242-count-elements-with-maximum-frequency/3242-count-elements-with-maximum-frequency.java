import java.util.*;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Count frequencies of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        // Find the maximum frequency
        int maxFreq = 0;
        for (int f : freq.values()) {
            if (f > maxFreq) {
                maxFreq = f;
            }
        }
        
        // Count total elements with that maximum frequency
        int count = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                count += f;  // add frequency itself, not just 1
            }
        }
        
        return count;
    }
}
