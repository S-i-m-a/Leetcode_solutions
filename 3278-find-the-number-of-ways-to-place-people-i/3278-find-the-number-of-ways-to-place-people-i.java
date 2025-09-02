class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        // Sort by x ascending, then y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        // For each point i as Alice
        for (int i = 0; i < n; i++) {
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int yi = points[i][1];
                int yj = points[j][1];
                // Valid only if yi >= yj and yj is greater than any previous yj
                if (yi >= yj && yj > maxY) {
                    count++;
                    maxY = yj;
                }
            }
        }

        return count;
    }
}
