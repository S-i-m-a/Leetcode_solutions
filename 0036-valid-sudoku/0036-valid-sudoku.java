class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashSets to track the seen numbers in rows, columns, and subgrids
        Set<String> seen = new HashSet<>();
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') {
                    // Create a unique key for rows, columns, and subgrids
                    String rowKey = "row" + row + num;
                    String colKey = "col" + col + num;
                    String subgridKey = "subgrid" + (row / 3) + (col / 3) + num;

                    // If any of these keys have been seen, it's an invalid board
                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(subgridKey)) {
                        return false;
                    }

                    // Add the keys to the set
                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(subgridKey);
                }
            }
        }

        return true;
    }
}
