class Solution {
    private int[] parent;  // Array to store the parent of each element in the Union-Find data structure
    private int[] size;    // Array to store the size of each set in the Union-Find data structure

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length;        // Total number of rows in the grid
        int cols = grid[0].length;     // Total number of columns in the grid
        parent = new int[rows * cols + 1]; // Initialize parent array, +1 is for the virtual root
        size = new int[rows * cols + 1];   // Initialize size array, +1 is for the virtual root
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i; // Initially each element is its own parent
            size[i] = 1;   // Initially the size of each set is 1
        }

        // Copy of the grid to modify and simulate hits
        int[][] gridCopy = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                gridCopy[i][j] = grid[i][j];
            }
        }

        // Apply hits to the grid copy
        for (int[] hit : hits) {
            gridCopy[hit[0]][hit[1]] = 0;
        }
      
        // Union all stable bricks in the first row with the virtual root node
        for (int j = 0; j < cols; ++j) {
            if (gridCopy[0][j] == 1) {
                union(j, rows * cols);
            }
        }

        // Union all adjacent stable bricks in the rest of the grid
        for (int i = 1; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (gridCopy[i][j] == 0) {
                    continue;
                }
                if (gridCopy[i - 1][j] == 1) {
                    union(i * cols + j, (i - 1) * cols + j);
                }
                if (j > 0 && gridCopy[i][j - 1] == 1) {
                    union(i * cols + j, i * cols + j - 1);
                }
            }
        }

        // Result array to store the number of bricks that fall after each hit 
        int[] result = new int[hits.length];
        // Array to represent direction [up, right, down, left] as pairs
        int[] dirs = {-1, 0, 1, 0, -1};
      
        // Reversely add back the bricks and union with neighbors if they are stable
        for (int k = hits.length - 1; k >= 0; --k) {
            int r = hits[k][0];
            int c = hits[k][1];
            if (grid[r][c] == 0) {
                continue; // Skip, since there was no brick at (r, c) to begin with
            }
            gridCopy[r][c] = 1;

            int prevSize = size[find(rows * cols)]; // Size of the top roof set before the union
            if (r == 0) {
                union(c, rows * cols); // Union first row brick with the virtual root
            }

            // Union the hit brick with its adjacent stable bricks
            for (int l = 0; l < 4; ++l) {
                int nr = r + dirs[l];
                int nc = c + dirs[l + 1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && gridCopy[nr][nc] == 1) {
                    union(r * cols + c, nr * cols + nc);
                }
            }
            int currSize = size[find(rows * cols)]; // Size of the top roof set after the union
            result[k] = Math.max(0, currSize - prevSize - 1); // Calculate fallen bricks not including the hit one
        }

        return result;
    }

    // Method to find the root of the set that element x belongs to
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression for efficiency
        }
        return parent[x];
    }

    // Method to union two sets that elements a and b belong to
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            size[rootB] += size[rootA]; // Merge the sets and update the size of the set
            parent[rootA] = rootB;      // Make the root of A point to root of B
        }
    }
}
