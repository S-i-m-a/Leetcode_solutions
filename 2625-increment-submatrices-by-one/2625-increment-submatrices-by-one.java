public class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        // Mark the difference array boundaries
        for (int[] q : queries) {
            int row1 = q[0];
            int col1 = q[1];
            int row2 = q[2];
            int col2 = q[3];

            mat[row1][col1]++;

            if (row2 + 1 < n) {
                mat[row2 + 1][col1]--;
            }
            if (col2 + 1 < n) {
                mat[row1][col2 + 1]--;
            }
            if (row2 + 1 < n && col2 + 1 < n) {
                mat[row2 + 1][col2 + 1]++;
            }
        }

        // Build the final matrix using 2D prefix sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    mat[i][j] += mat[i - 1][j];
                }
                if (j > 0) {
                    mat[i][j] += mat[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    mat[i][j] -= mat[i - 1][j - 1];
                }
            }
        }

        return mat;
    }
}
