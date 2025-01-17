class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use three arrays of sets to store the seen numbers for rows, columns, and subgrids
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // Check if the number has been seen in the same row, column, or subgrid
                    String num = String.valueOf(board[i][j]);
                    
                    // Check row, column, and subgrid using a combination of row/column/subgrid information
                    if (!seen.add(num + " in row " + i) ||
                        !seen.add(num + " in col " + j) ||
                        !seen.add(num + " in subgrid " + i / 3 + "-" + j / 3)) {
                        return false; // Duplicate found, return false
                    }
                }
            }
        }
        
        return true; // No duplicates found, board is valid
    }
}
