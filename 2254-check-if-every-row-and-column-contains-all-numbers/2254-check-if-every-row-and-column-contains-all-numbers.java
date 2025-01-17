class Solution {
    public boolean checkValid(int[][] grid) {
        int n = grid.length;
        Set<Integer> expectedSet = new HashSet<>();
        
        // Populate the expected set with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            expectedSet.add(i);
        }
        
        // Check each row
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(grid[i][j]);
            }
            if (!rowSet.equals(expectedSet)) {
                return false; // Row does not contain all numbers from 1 to n
            }
        }

        // Check each column
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                colSet.add(grid[i][j]);
            }
            if (!colSet.equals(expectedSet)) {
                return false; // Column does not contain all numbers from 1 to n
            }
        }

        return true; // All rows and columns are valid
    }
}
