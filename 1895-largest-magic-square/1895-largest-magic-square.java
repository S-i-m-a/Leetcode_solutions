class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxSide = Math.min(m, n);

        // Try sizes from largest to smallest
        for (int k = maxSide; k >= 1; k--) {
            if (existsMagicSquare(grid, k)) {
                return k;
            }
        }
        return 1;
    }

    // Check if there's any k x k magic square in the grid
    private boolean existsMagicSquare(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        for (int r = 0; r <= m - k; r++) {
            for (int c = 0; c <= n - k; c++) {
                if (isMagic(grid, r, c, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if subgrid with top-left at (r, c) and side k is magic
    private boolean isMagic(int[][] grid, int r, int c, int k) {
        long target = 0;

        // Sum of main diagonal
        for (int i = 0; i < k; i++) {
            target += grid[r + i][c + i];
        }

        // Sum of anti diagonal
        long anti = 0;
        for (int i = 0; i < k; i++) {
            anti += grid[r + i][c + k - 1 - i];
        }
        if (anti != target) return false;

        // Check all rows
        for (int i = 0; i < k; i++) {
            long sum = 0;
            for (int j = 0; j < k; j++) {
                sum += grid[r + i][c + j];
            }
            if (sum != target) return false;
        }

        // Check all columns
        for (int j = 0; j < k; j++) {
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += grid[r + i][c + j];
            }
            if (sum != target) return false;
        }

        return true;
    }
}
