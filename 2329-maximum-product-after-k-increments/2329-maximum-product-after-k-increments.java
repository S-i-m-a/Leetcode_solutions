import java.util.PriorityQueue;

public class Solution {
    public int maximumProduct(int[] nums, int k) {
        // Min-Heap to efficiently manage the smallest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        // Perform k operations
        while (k-- > 0) {
            int smallest = minHeap.poll(); // Get the smallest element
            minHeap.add(smallest + 1);    // Increment and push it back
        }

        // Calculate the product of all elements modulo 10^9 + 7
        long product = 1;
        int mod = (int) 1e9 + 7;
        while (!minHeap.isEmpty()) {
            product = (product * minHeap.poll()) % mod;
        }

        return (int) product;
    }
}
