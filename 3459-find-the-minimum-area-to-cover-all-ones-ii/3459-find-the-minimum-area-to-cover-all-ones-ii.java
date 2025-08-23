class Solution {
    // Helper to compute minimal area covering all 1's in subgrid
    private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = -1, y2 = -1;
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        if (x2 == -1) return 0;  // No 1's in subgrid
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = m * n;  // upper bound

        // Two horizontal splits
        for (int i1 = 0; i1 < m - 2; i1++) {
            for (int i2 = i1 + 1; i2 < m - 1; i2++) {
                int sum = minimumArea(grid, 0, i1, 0, n - 1)
                        + minimumArea(grid, i1 + 1, i2, 0, n - 1)
                        + minimumArea(grid, i2 + 1, m - 1, 0, n - 1);
                ans = Math.min(ans, sum);
            }
        }

        // Two vertical splits
        for (int j1 = 0; j1 < n - 2; j1++) {
            for (int j2 = j1 + 1; j2 < n - 1; j2++) {
                int sum = minimumArea(grid, 0, m - 1, 0, j1)
                        + minimumArea(grid, 0, m - 1, j1 + 1, j2)
                        + minimumArea(grid, 0, m - 1, j2 + 1, n - 1);
                ans = Math.min(ans, sum);
            }
        }

        // Horizontal, then vertical on upper
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int sum = minimumArea(grid, 0, i, 0, n - 1)
                        + minimumArea(grid, i + 1, m - 1, 0, j)
                        + minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, sum);
            }
        }

        // Horizontal, then vertical on lower
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                int sum = minimumArea(grid, i, m - 1, 0, n - 1)
                        + minimumArea(grid, 0, i - 1, 0, j)
                        + minimumArea(grid, 0, i - 1, j + 1, n - 1);
                ans = Math.min(ans, sum);
            }
        }

        // Vertical, then horizontal on left
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m - 1; i++) {
                int sum = minimumArea(grid, 0, m - 1, 0, j)
                        + minimumArea(grid, 0, i, j + 1, n - 1)
                        + minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, sum);
            }
        }

        // Vertical, then horizontal on right
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m - 1; i++) {
                int sum = minimumArea(grid, 0, m - 1, j, n - 1)
                        + minimumArea(grid, 0, i, 0, j - 1)
                        + minimumArea(grid, i + 1, m - 1, 0, j - 1);
                ans = Math.min(ans, sum);
            }
        }

        return ans;
    }
}
