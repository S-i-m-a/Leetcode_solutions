class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0, r = n - 1;

        // skip all leading 'L' — these cars move left forever, no collisions
        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        // skip all trailing 'R' — these cars move right forever, no collisions
        while (r >= 0 && directions.charAt(r) == 'R') {
            r--;
        }

        int collisions = 0;
        // In the remaining segment [l..r], all 'L' or 'R' will eventually collide
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
