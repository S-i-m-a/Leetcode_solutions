public class Solution {
    private int[][] grid1, grid2;
    private int m, n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        m = grid1.length;
        n = grid1[0].length;
        int count = 0;

        // Perform DFS on each unvisited cell in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    // Start DFS and check if the island in grid2 is a sub-island of grid1
                    if (dfs(i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int i, int j) {
        // If the current cell is out of bounds or water (0) in grid2, return true (no need to check further)
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }

        // Mark this cell as visited in grid2
        grid2[i][j] = 0;

        // Check if the current cell is part of a valid sub-island
        boolean isSubIsland = grid1[i][j] == 1;

        // Explore the four possible directions (up, down, left, right)
        isSubIsland &= dfs(i + 1, j);  // Down
        isSubIsland &= dfs(i - 1, j);  // Up
        isSubIsland &= dfs(i, j + 1);  // Right
        isSubIsland &= dfs(i, j - 1);  // Left

        return isSubIsland;
    }
}
