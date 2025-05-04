import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int[] domino : dominoes) {
            // Normalize the domino representation
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            // Add the current count to the result
            result += count.getOrDefault(key, 0);
            // Increment the count for this key
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        return result;
    }
}
