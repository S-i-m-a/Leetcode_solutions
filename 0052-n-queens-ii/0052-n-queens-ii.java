class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1]; // To store the number of solutions
        boolean[] cols = new boolean[n]; // Track if a column is under attack
        boolean[] diag1 = new boolean[2 * n]; // Track if a main diagonal is under attack
        boolean[] diag2 = new boolean[2 * n]; // Track if an anti-diagonal is under attack
        backtrack(count, n, 0, cols, diag1, diag2);
        return count[0];
    }

    private void backtrack(int[] count, int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            // If we placed queens in all rows, increment the count
            count[0]++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;  // Main diagonal index
            int d2 = row + col;      // Anti-diagonal index

            // Check if the current column or diagonals are under attack
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue; // Skip this column
            }

            // Place the queen and mark the column and diagonals as under attack
            cols[col] = diag1[d1] = diag2[d2] = true;

            // Recursively place queens in the next row
            backtrack(count, n, row + 1, cols, diag1, diag2);

            // Backtrack: remove the queen and mark the column and diagonals as available
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}
