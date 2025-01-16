import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        // Min-heap to store the elements along with their positions in the matrix
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Initialize the heap with the first element of each row (matrix[i][0])
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0}); // {value, row, col}
        }
        
        // Pop from the heap k times to get the kth smallest element
        for (int i = 0; i < k - 1; i++) {
            int[] current = minHeap.poll();
            int row = current[1], col = current[2];
            
            // If there is a next element in the row, push it into the heap
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        
        // The kth smallest element is now at the root of the heap
        return minHeap.poll()[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] matrix1 = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k1 = 8;
        System.out.println(solution.kthSmallest(matrix1, k1)); // Output: 13

        // Test case 2
        int[][] matrix2 = {{-5}};
        int k2 = 1;
        System.out.println(solution.kthSmallest(matrix2, k2)); // Output: -5
    }
}
