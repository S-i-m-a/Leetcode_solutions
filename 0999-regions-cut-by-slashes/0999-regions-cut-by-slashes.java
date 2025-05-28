class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * 3;
        int[][] expanded = new int[size][size];

        // Expand each cell into 3x3 and mark slashes
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == '/') {
                    expanded[i * 3][j * 3 + 2] = 1;
                    expanded[i * 3 + 1][j * 3 + 1] = 1;
                    expanded[i * 3 + 2][j * 3] = 1;
                } else if (row[j] == '\\') {
                    expanded[i * 3][j * 3] = 1;
                    expanded[i * 3 + 1][j * 3 + 1] = 1;
                    expanded[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        // Count regions using DFS
        int regions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (expanded[i][j] == 0) {
                    dfs(expanded, i, j);
                    regions++;
                }
            }
        }

        return regions;
    }

    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 0)
            return;

        grid[i][j] = 2;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
