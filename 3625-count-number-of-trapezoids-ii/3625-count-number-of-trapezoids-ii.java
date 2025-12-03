class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Key, Map<Integer, Integer>> t = new HashMap<>();
        Map<Key, Map<Integer, Integer>> v = new HashMap<>();

        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                int g = gcd(dx, dy);
                int sx = dx / g;
                int sy = dy / g;

                int des = sx * points[i][1] - sy * points[i][0];

                Key keySlope = new Key(sx, sy);
                Key keyVector = new Key(dx, dy);

                t.computeIfAbsent(keySlope, k -> new HashMap<>()).merge(des, 1, Integer::sum);
                v.computeIfAbsent(keyVector, k -> new HashMap<>()).merge(des, 1, Integer::sum);
            }
        }

        return countPairs(t) - countPairs(v) / 2;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int countPairs(Map<Key, Map<Integer, Integer>> mapData) {
        int ans = 0;

        for (Map<Integer, Integer> inner : mapData.values()) {
            int currentSum = inner.values().stream().mapToInt(Integer::intValue).sum();

            for (int val : inner.values()) {
                currentSum -= val;
                ans += (long) val * currentSum;
            }
        }

        return ans;
    }

    private static class Key {
        private final int x;
        private final int y;

        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (x != key.x) return false;
            return y == key.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}