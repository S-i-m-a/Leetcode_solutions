import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // If intervals are empty, return an empty array
        if (intervals.length == 0) {
            return new int[0][0];
        }
        
        // Sort intervals based on their starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Initialize the list to store merged intervals
        List<int[]> merged = new ArrayList<>();
        
        // Add the first interval to the result
        merged.add(intervals[0]);
        
        // Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastMerged = merged.get(merged.size() - 1);
            
            // If the current interval overlaps with the last merged interval
            if (current[0] <= lastMerged[1]) {
                // Merge the intervals by updating the end of the last merged interval
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // Otherwise, no overlap, so add the current interval to the result
                merged.add(current);
            }
        }
        
        // Convert the list back to an array and return
        return merged.toArray(new int[merged.size()][]);
    }
}
