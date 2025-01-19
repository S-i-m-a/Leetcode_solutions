import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> currentBoard, int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // If we've placed queens in all rows, add the current solution to the result
        if (row == n) {
            result.add(new ArrayList<>(currentBoard));
            return;
        }
        
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;  // Main diagonal index
            int d2 = row + col;      // Anti-diagonal index
            
            // Check if the current column or diagonals are under attack
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;  // Skip this column
            }
            
            // Place the queen
            cols[col] = diag1[d1] = diag2[d2] = true;
            currentBoard.add(createRow(col, n));  // Add the queen's row representation
            
            // Move to the next row
            backtrack(result, currentBoard, n, row + 1, cols, diag1, diag2);
            
            // Backtrack: Remove the queen and mark the column and diagonals as available
            currentBoard.remove(currentBoard.size() - 1);
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private String createRow(int col, int n) {
        // Create a row string with a queen at the specified column
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            row[i] = '.';
        }
        row[col] = 'Q';
        return new String(row);
    }
}
