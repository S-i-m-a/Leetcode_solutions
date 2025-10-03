import java.util.PriorityQueue;

public class Solution {
    // A helper class to store cell info in the priority queue
    private static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;  // effective height / water level at this cell

        public Cell(int r, int c, int h) {
            this.row = r;
            this.col = c;
            this.height = h;
        }

        // For min-heap ordering by height
        @Override
        public int compareTo(Cell other) {
            return this.height - other.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        // If too small, no water can be trapped
        if (m < 3 || n < 3) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        // Add all boundary cells into pq and mark visited
        for (int i = 0; i < m; i++) {
            // left boundary
            visited[i][0] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            // right boundary
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int j = 1; j < n - 1; j++) {
            // top boundary
            visited[0][j] = true;
            pq.offer(new Cell(0, j, heightMap[0][j]));
            // bottom boundary
            visited[m - 1][j] = true;
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        int totalWater = 0;
        int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int cr = cell.row;
            int cc = cell.col;
            int ch = cell.height;

            // Explore neighbors
            for (int[] d : dirs) {
                int nr = cr + d[0];
                int nc = cc + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;

                int neighborHeight = heightMap[nr][nc];
                // If current boundary is higher than neighbor, water can be trapped
                if (ch > neighborHeight) {
                    totalWater += (ch - neighborHeight);
                }

                // Push neighbor with effective height = max(ch, neighborHeight)
                // Because water cannot lower boundary inwards
                pq.offer(new Cell(nr, nc, Math.max(ch, neighborHeight)));
            }
        }

        return totalWater;
    }
}
