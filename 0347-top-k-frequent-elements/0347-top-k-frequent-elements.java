import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map to count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Min-Heap to keep the top K elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );

        // Add elements to the heap
        for (int key : frequencyMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Prepare the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("Top K Frequent Elements: " + Arrays.toString(solution.topKFrequent(nums, k)));
    }
}
