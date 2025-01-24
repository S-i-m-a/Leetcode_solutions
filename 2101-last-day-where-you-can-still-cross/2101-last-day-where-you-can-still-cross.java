class Solution {
    private int[] parent; // Union-find array to track connected components
    private int rowCount; // Number of rows in the grid
    private int colCount; // Number of columns in the grid
    private boolean[][] grid; // Representation of the grid's current state
    private final int[][] directions = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}}; // 4 directional vectors

    // Method to determine the latest day to cross the river
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = row * col;
        this.rowCount = row;
        this.colCount = col;
        this.parent = new int[n + 2];
        // Initialize the union-find structure
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
        }
        this.grid = new boolean[row][col];
        int top = n, bottom = n + 1; // Virtual top and bottom nodes
      
        // Process cells in reverse order
        for (int k = cells.length - 1; k >= 0; --k) {
            int r = cells[k][0] - 1; // Adjusted row index (0-based)
            int c = cells[k][1] - 1; // Adjusted column index (0-based)
            grid[r][c] = true; // Set the current cell to be available
            // Connect current cell with its adjacent available cells
            for (int[] direction : directions) {
                int nextR = r + direction[0];
                int nextC = c + direction[1];
                if (isInsideGrid(nextR, nextC)) {
                    union(getIndex(r, c), getIndex(nextR, nextC));
                }
            }
            // Connect to virtual top and bottom nodes if applicable
            if (r == 0) {
                union(getIndex(r, c), top);
            }
            if (r == rowCount - 1) {
                union(getIndex(r, c), bottom);
            }
            // If top node and bottom node are connected, return current day
            if (find(top) == find(bottom)) {
                return k;
            }
        }
      
        return 0; // If there is no way to cross, return 0
    }

    // Find method for union-find, with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
  
    // Union method for union-find, connects two elements
    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    // Helper function to determine if a cell is within the grid
    private boolean isInsideGrid(int r, int c) {
        return r >= 0 && r < rowCount && c >= 0 && c < colCount && grid[r][c];
    }

    // Helper function to convert 2D cell indices to 1D union-find index
    private int getIndex(int r, int c) {
        return r * colCount + c;
    }
}