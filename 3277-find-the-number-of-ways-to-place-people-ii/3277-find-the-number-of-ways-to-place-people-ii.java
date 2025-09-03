import java.util.*;

public class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        // Sort ascending by x, then descending by y
        Arrays.sort(points, Comparator
            .comparingInt((int[] p) -> p[0])
            .thenComparingInt(p -> -p[1]));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (points[i][1] >= points[j][1] && points[j][1] > maxY) {
                    ans++;
                    maxY = points[j][1];
                }
            }
        }
        return ans;
    }
}
