class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // Total sum of absolute values
        long totalSum = 0;
      
        // Track the minimum absolute value in the matrix
        int minAbsValue = Integer.MAX_VALUE;
      
        // Count of negative numbers
        int negativeCount = 0;
      
        // Iterate through each row in the matrix
        for (int[] row : matrix) {
            // Iterate through each element in the row
            for (int element : row) {
                // Count negative numbers
                if (element < 0) {
                    negativeCount++;
                }
              
                // Get absolute value of current element
                int absoluteValue = Math.abs(element);
              
                // Update minimum absolute value
                minAbsValue = Math.min(minAbsValue, absoluteValue);
              
                // Add absolute value to total sum
                totalSum += absoluteValue;
            }
        }
      
        // If even number of negatives, all can be made positive
        // If odd number of negatives, one value must remain negative (choose the smallest)
        if (negativeCount % 2 == 0) {
            return totalSum;
        } else {
            // Subtract twice the minimum value (once to remove it from sum, once for negative)
            return totalSum - 2 * minAbsValue;
        }
    }
}