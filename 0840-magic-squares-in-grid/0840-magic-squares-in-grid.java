class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // loop through all possible 3x3 starting top-left positions
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        // must contain all numbers 1 to 9 exactly once
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[r + i][c + j];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }

        // calculate all required sums
        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2]; // first row sum

        // check rows
        for (int i = 1; i < 3; i++) {
            int rowSum = grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2];
            if (rowSum != sum) return false;
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            int colSum = grid[r][c + j] + grid[r + 1][c + j] + grid[r + 2][c + j];
            if (colSum != sum) return false;
        }

        // check diagonals
        int diag1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int diag2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];
        if (diag1 != sum || diag2 != sum) return false;

        return true;
    }
}
