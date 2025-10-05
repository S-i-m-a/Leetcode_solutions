import java.util.*;

public class Solution {
    private int m, n;
    private int[][] heights;
    private boolean[][] pacificReach;
    private boolean[][] atlanticReach;
    private final int[][] DIRS = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        if (m == 0) return Collections.emptyList();
        n = heights[0].length;
        
        pacificReach = new boolean[m][n];
        atlanticReach = new boolean[m][n];
        
        // Run DFS from all Pacific-border cells
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificReach);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacificReach);
        }
        
        // Run DFS from all Atlantic-border cells
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlanticReach);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlanticReach);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        // Collect cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReach[i][j] && atlanticReach[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int i, int j, boolean[][] reach) {
        if (reach[i][j]) {
            return;
        }
        reach[i][j] = true;
        
        for (int[] d : DIRS) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
            // Water can flow from neighbor to current only if neighbor’s height >= current
            if (heights[ni][nj] < heights[i][j]) continue;
            dfs(ni, nj, reach);
        }
    }
}
