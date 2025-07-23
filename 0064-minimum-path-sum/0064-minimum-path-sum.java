class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Traverse from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1 && j < n - 1) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if (i < m - 1) {
                    grid[i][j] += grid[i + 1][j];
                } else if (j < n - 1) {
                    grid[i][j] += grid[i][j + 1];
                }
            }
        }

        return grid[0][0];
    }
}
