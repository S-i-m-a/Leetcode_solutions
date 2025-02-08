class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {
        // Base Case: If the entire section contains the same value, create a leaf node
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        // Divide the grid into four quadrants
        int newSize = size / 2;
        Node topLeft = build(grid, row, col, newSize);
        Node topRight = build(grid, row, col + newSize, newSize);
        Node bottomLeft = build(grid, row + newSize, col, newSize);
        Node bottomRight = build(grid, row + newSize, col + newSize, newSize);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // Helper function to check if the subgrid has all the same values
    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}
