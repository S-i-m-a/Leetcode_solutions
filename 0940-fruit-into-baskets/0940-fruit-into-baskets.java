import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0, left = 0;
        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            // Shrink window until we have at most 2 fruit types
            while (count.size() > 2) {
                int c = fruits[left];
                count.put(c, count.get(c) - 1);
                if (count.get(c) == 0) {
                    count.remove(c);
                }
                left++;
            }

            // Window [left..right] is valid
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
