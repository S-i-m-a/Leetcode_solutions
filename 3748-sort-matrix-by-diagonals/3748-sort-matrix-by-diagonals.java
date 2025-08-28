import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Map each diagonal (i - j) to its elements
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 1. Collect elements by diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        // 2. Sort each diagonal correctly
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> diag = entry.getValue();
            if (entry.getKey() >= 0) {
                // bottom-left including main diagonal → descending
                diag.sort(Collections.reverseOrder());
            } else {
                // top-right diagonals → ascending
                Collections.sort(diag);
            }
        }

        // 3. Place back sorted elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> diag = map.get(key);
                grid[i][j] = diag.remove(0);
            }
        }

        return grid;
    }
}
