import java.util.PriorityQueue;

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        // Min-heap to store the fractions, where we store the value and the indices (i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            // Compare the fractions a[0] / a[1] and b[0] / b[1]
            return (arr[a[0]] * arr[b[1]]) - (arr[b[0]] * arr[a[1]]);
        });

        // Initialize the heap with fractions arr[0] / arr[1], arr[0] / arr[2], ..., arr[0] / arr[n-1]
        for (int j = 1; j < n; j++) {
            minHeap.offer(new int[]{0, j});
        }

        // Pop k-1 times, and then the top of the heap will be the kth smallest
        for (int i = 0; i < k - 1; i++) {
            int[] fraction = minHeap.poll();
            int x = fraction[0], y = fraction[1];
            // If we can move the numerator's index, we push the next fraction formed by (x+1, y)
            if (x + 1 < y) {
                minHeap.offer(new int[]{x + 1, y});
            }
        }

        // The top element of the heap will now be the kth smallest fraction
        int[] result = minHeap.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {1, 2, 3, 5};
        int k1 = 3;
        int[] result1 = solution.kthSmallestPrimeFraction(arr1, k1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

        int[] arr2 = {1, 7};
        int k2 = 1;
        int[] result2 = solution.kthSmallestPrimeFraction(arr2, k2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
    }
}
