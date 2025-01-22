import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap to store the top k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if size exceeds k
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
