import java.util.*;

class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        // Get the number of rows and columns in the matrix
        int rows = mat.length;
        int cols = mat[0].length;

        // Use a set to store possible sums from the previous row
        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0); // Start with a sum of 0

        // Iterate through each row of the matrix
        for (int[] row : mat) {
            Set<Integer> nextSums = new HashSet<>();
            
            // For each possible sum, add all elements of the current row
            for (int sum : possibleSums) {
                for (int num : row) {
                    nextSums.add(sum + num);
                }
            }

            // Update the possible sums for the next iteration
            possibleSums = nextSums;
        }

        // Find the minimum absolute difference between the sums and the target
        int minDifference = Integer.MAX_VALUE;
        for (int sum : possibleSums) {
            minDifference = Math.min(minDifference, Math.abs(sum - target));
        }

        return minDifference;
    }
}
