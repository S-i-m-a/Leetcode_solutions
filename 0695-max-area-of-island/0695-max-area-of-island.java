public class Solution {
    private int rows;
    private int cols;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        int maxArea = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                maxArea = Math.max(maxArea, dfs(i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }

        int area = 1;
        grid[row][col] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};

        for (int k = 0; k < 4; ++k) {
            int nextRow = row + dirs[k];
            int nextCol = col + dirs[k + 1];

            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                area += dfs(nextRow, nextCol);
            }
        }
        return area;
    }
}
