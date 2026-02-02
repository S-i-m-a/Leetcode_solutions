class Solution {
    // TreeMap to store the k smallest elements (left partition)
    private final TreeMap<Integer, Integer> leftPartition = new TreeMap<>();
    // TreeMap to store elements larger than the k smallest (right partition)
    private final TreeMap<Integer, Integer> rightPartition = new TreeMap<>();
    // Sum of elements in the left partition
    private long currentSum;
    // Number of elements in the left partition
    private int leftPartitionSize;

    public long minimumCost(int[] nums, int k, int dist) {
        // Adjust k since nums[0] is always included
        --k;
      
        // Initialize with nums[0] as it's always part of the answer
        currentSum = nums[0];
      
        // Add all elements in the initial window to the left partition
        for (int i = 1; i < dist + 2; ++i) {
            currentSum += nums[i];
            leftPartition.merge(nums[i], 1, Integer::sum);
        }
      
        // Initial window size (excluding nums[0])
        leftPartitionSize = dist + 1;
      
        // Balance the partitions to keep exactly k elements in left partition
        while (leftPartitionSize > k) {
            moveLeftToRight();
        }
      
        // Initialize answer with the sum of first valid window
        long answer = currentSum;
      
        // Slide the window through the rest of the array
        for (int i = dist + 2; i < nums.length; ++i) {
            // Remove the element that's going out of the window
            int elementToRemove = nums[i - dist - 1];
          
            // Check if element to remove is in left partition
            if (leftPartition.containsKey(elementToRemove)) {
                // Remove from left partition and update sum
                if (leftPartition.merge(elementToRemove, -1, Integer::sum) == 0) {
                    leftPartition.remove(elementToRemove);
                }
                currentSum -= elementToRemove;
                --leftPartitionSize;
            } else {
                // Remove from right partition
                if (rightPartition.merge(elementToRemove, -1, Integer::sum) == 0) {
                    rightPartition.remove(elementToRemove);
                }
            }
          
            // Add the new element entering the window
            int elementToAdd = nums[i];
          
            // Determine which partition to add the new element to
            if (elementToAdd < leftPartition.lastKey()) {
                // Add to left partition if it's smaller than the largest in left
                leftPartition.merge(elementToAdd, 1, Integer::sum);
                ++leftPartitionSize;
                currentSum += elementToAdd;
            } else {
                // Otherwise add to right partition
                rightPartition.merge(elementToAdd, 1, Integer::sum);
            }
          
            // Rebalance partitions to maintain exactly k elements in left
            while (leftPartitionSize < k) {
                moveRightToLeft();
            }
            while (leftPartitionSize > k) {
                moveLeftToRight();
            }
          
            // Update minimum answer
            answer = Math.min(answer, currentSum);
        }
      
        return answer;
    }

    /**
     * Move the largest element from left partition to right partition
     */
    private void moveLeftToRight() {
        // Get the largest element from left partition
        int elementToMove = leftPartition.lastKey();
      
        // Update sum as element leaves left partition
        currentSum -= elementToMove;
      
        // Remove from left partition
        if (leftPartition.merge(elementToMove, -1, Integer::sum) == 0) {
            leftPartition.remove(elementToMove);
        }
        --leftPartitionSize;
      
        // Add to right partition
        rightPartition.merge(elementToMove, 1, Integer::sum);
    }

    /**
     * Move the smallest element from right partition to left partition
     */
    private void moveRightToLeft() {
        // Get the smallest element from right partition
        int elementToMove = rightPartition.firstKey();
      
        // Remove from right partition
        if (rightPartition.merge(elementToMove, -1, Integer::sum) == 0) {
            rightPartition.remove(elementToMove);
        }
      
        // Add to left partition
        leftPartition.merge(elementToMove, 1, Integer::sum);
      
        // Update sum as element enters left partition
        currentSum += elementToMove;
        ++leftPartitionSize;
    }
}
