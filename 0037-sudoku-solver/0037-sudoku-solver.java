class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int pos) {
        if (pos == 81) {
            // All 81 cells processed → solution found
            return true;
        }

        int row = pos / 9;
        int col = pos % 9;

        if (board[row][col] != '.') {
            return solve(board, pos + 1); // Skip filled cells
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (solve(board, pos + 1)) {
                    return true; // Early return on success
                }
                board[row][col] = '.'; // Backtrack
            }
        }

        return false; // No valid digit leads to solution here
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check column
            if (board[i][col] == c) return false;
            // Check row
            if (board[row][i] == c) return false;
            // Check 3×3 subgrid
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
