import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>(); // To store the frequency of elements
        Map<Integer, Integer> firstIndexMap = new HashMap<>(); // To store the first occurrence of elements
        Map<Integer, Integer> lastIndexMap = new HashMap<>(); // To store the last occurrence of elements

        int maxDegree = 0; // To track the maximum degree of the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxDegree = Math.max(maxDegree, frequencyMap.get(num));
            firstIndexMap.putIfAbsent(num, i);
            lastIndexMap.put(num, i);
        }

        int minLength = nums.length; // Initialize to the maximum possible length
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == maxDegree) {
                int length = lastIndexMap.get(num) - firstIndexMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println("Shortest Subarray Length: " + solution.findShortestSubArray(nums));
    }
}
