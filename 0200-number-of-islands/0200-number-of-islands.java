public class Solution {
    public int numIslands(char[][] grid) {
        // Edge case: if grid is empty, return 0
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        // Traverse every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If a land cell is found, perform DFS
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        return numIslands;
    }

    // Helper function for DFS
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // Check if out of bounds or the cell is water ('0')
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited by turning it into water ('0')
        grid[i][j] = '0';

        // Explore the neighboring cells (up, down, left, right)
        dfs(grid, i + 1, j, m, n); // down
        dfs(grid, i - 1, j, m, n); // up
        dfs(grid, i, j + 1, m, n); // right
        dfs(grid, i, j - 1, m, n); // left
    }
}
