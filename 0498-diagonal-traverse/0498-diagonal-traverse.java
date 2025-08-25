public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] output = new int[m * n];
        int idx = 0;

        for (int diag = 0; diag <= m + n - 2; ++diag) {
            if (diag % 2 == 0) {
                // Even diagonals: traverse from bottom-left to top-right
                for (int k = Math.max(0, diag - m + 1); k <= Math.min(diag, n - 1); ++k) {
                    output[idx++] = mat[diag - k][k];
                }
            } else {
                // Odd diagonals: traverse from top-right to bottom-left
                for (int k = Math.max(0, diag - n + 1); k <= Math.min(diag, m - 1); ++k) {
                    output[idx++] = mat[k][diag - k];
                }
            }
        }
        return output;
    }
}
