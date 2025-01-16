import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return result; // If any array is empty, return an empty result.
        }

        // Min-heap to store pairs of indices and their sum
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]])); // Comparator based on sum
        
        // Initialize the heap with pairs from the first element of nums1 and all elements of nums2
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // Extract k smallest sums
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[0], j = pair[1];

            // Add the current pair to the result as a List<Integer>
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there's a next element in nums2, add the new pair to the heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;
        List<List<Integer>> result1 = solution.kSmallestPairs(nums1_1, nums2_1, k1);
        for (List<Integer> pair : result1) {
            System.out.println(pair);
        }
        // Output: [[1, 2], [1, 4], [1, 6]]

        // Test case 2
        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 2;
        List<List<Integer>> result2 = solution.kSmallestPairs(nums1_2, nums2_2, k2);
        for (List<Integer> pair : result2) {
            System.out.println(pair);
        }
        // Output: [[1, 1], [1, 1]]
    }
}
