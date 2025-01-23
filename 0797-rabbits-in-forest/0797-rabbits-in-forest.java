import java.util.HashMap;

public class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Count the frequency of each reported number
        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }
        
        int totalRabbits = 0;
        
        // For each unique number of reported rabbits
        for (int count : countMap.keySet()) {
            int groupSize = count + 1;
            int groupCount = countMap.get(count);
            
            // Number of groups of size `groupSize` needed
            totalRabbits += (groupCount + groupSize - 1) / groupSize * groupSize;
        }
        
        return totalRabbits;
    }
}
