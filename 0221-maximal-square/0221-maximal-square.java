public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSideLength = 0;

        // Create a dp array to store the size of the largest square that can end at each cell
        int[][] dp = new int[rows + 1][cols + 1];

        // Traverse through each cell in the matrix
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // The side length of the largest square ending at matrix[i-1][j-1]
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSideLength = Math.max(maxSideLength, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return maxSideLength * maxSideLength;
    }
}
