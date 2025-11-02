class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 0 = unguarded/unoccupied, 1 = guarded, 2 = guard, 3 = wall
        int[][] grid = new int[m][n];
        
        // Mark guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 2;
        }
        // Mark walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 3;
        }
        
        // Direction vectors: up, right, down, left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        // For each guard, cast rays in all four directions
        for (int[] g : guards) {
            int r0 = g[0];
            int c0 = g[1];
            
            for (int d = 0; d < 4; ++d) {
                int r = r0 + dr[d];
                int c = c0 + dc[d];
                
                while (r >= 0 && r < m && c >= 0 && c < n) {
                    if (grid[r][c] == 2 || grid[r][c] == 3) {
                        // Another guard or a wall blocks further vision
                        break;
                    }
                    // Mark as guarded if currently unoccupied (0)
                    if (grid[r][c] == 0) {
                        grid[r][c] = 1;
                    }
                    // Move further along direction
                    r += dr[d];
                    c += dc[d];
                }
            }
        }
        
        // Count cells that remain unoccupied (0)
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
