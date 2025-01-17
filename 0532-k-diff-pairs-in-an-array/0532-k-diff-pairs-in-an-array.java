import java.util.HashMap;

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // Difference cannot be negative
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Populate the frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (k == 0) {
                // Special case: k = 0, we need at least two occurrences
                if (map.get(key) > 1) {
                    count++;
                }
            } else {
                // Check if there exists another number such that the difference is k
                if (map.containsKey(key + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println("Number of k-diff pairs: " + solution.findPairs(nums, k)); // Output: 2
    }
}
