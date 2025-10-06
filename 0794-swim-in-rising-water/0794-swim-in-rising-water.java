import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // dist[r][c] = minimum time needed to reach (r,c)
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        
        // Min-heap: entries (time, r, c)
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));
        pq.offer(new Cell(0, 0, grid[0][0]));
        
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int r = cur.r, c = cur.c, t = cur.time;
            
            // If we reached target, we can return
            if (r == n-1 && c == n-1) {
                return t;
            }
            
            // If this popped entry is worse than the best we already have, skip
            if (t > dist[r][c]) {
                continue;
            }
            
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                
                // time to enter neighbor = max(current time, grid[nr][nc])
                int nt = Math.max(t, grid[nr][nc]);
                if (nt < dist[nr][nc]) {
                    dist[nr][nc] = nt;
                    pq.offer(new Cell(nr, nc, nt));
                }
            }
        }
        
        // Should always reach
        return -1;
    }
    
    private static class Cell {
        int r, c;
        int time;
        Cell(int _r, int _c, int _time) {
            r = _r; c = _c; time = _time;
        }
    }
}
