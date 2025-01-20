import java.util.*;

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> result = new ArrayList<>();
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                result.add(new int[]{r, c});
            }
        }
        
        result.sort((a, b) -> Integer.compare(Math.abs(a[0] - r0) + Math.abs(a[1] - c0), Math.abs(b[0] - r0) + Math.abs(b[1] - c0)));
        
        return result.toArray(new int[0][0]);
    }
}
