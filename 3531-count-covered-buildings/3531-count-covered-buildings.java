import java.util.*;

public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Map each row x to sorted list of y-coords in that row
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        // Map each column y to sorted list of x-coords in that column
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMap.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            colMap.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        for (List<Integer> ys : rowMap.values()) {
            Collections.sort(ys);
        }
        for (List<Integer> xs : colMap.values()) {
            Collections.sort(xs);
        }

        int covered = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            List<Integer> ys = rowMap.get(x);
            List<Integer> xs = colMap.get(y);

            // Check left-right: y strictly between min and max in same row
            boolean hasLR = (ys.get(0) < y && y < ys.get(ys.size() - 1));
            // Check up-down: x strictly between min and max in same column
            boolean hasUD = (xs.get(0) < x && x < xs.get(xs.size() - 1));

            if (hasLR && hasUD) {
                covered++;
            }
        }

        return covered;
    }
}
