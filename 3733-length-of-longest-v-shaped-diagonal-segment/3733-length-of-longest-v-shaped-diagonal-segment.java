import java.util.*;

class Solution {
    private static final int[][] DIRS = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    private int n, m;
    // memo[i][j][turned][dir]
    private Integer[][][][][] memo;

    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        memo = new Integer[n][m][2][2][4]; // [i][j][turned?0/1][hashNum?][dir]
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; ++d) {
                        int dx = DIRS[d][0], dy = DIRS[d][1];
                        ans = Math.max(ans, 1 + dfs(grid, i + dx, j + dy, false, 2, d));
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, boolean turned, int num, int dir) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != num) {
            return 0;
        }

        int turnedIdx = turned ? 1 : 0;
        int hashNum = Math.max(0, num - 1);

        if (memo[i][j][turnedIdx][hashNum][dir] != null) {
            return memo[i][j][turnedIdx][hashNum][dir];
        }

        int nextNum = (num == 2) ? 0 : 2;
        int res = 1 + dfs(grid, i + DIRS[dir][0], j + DIRS[dir][1], turned, nextNum, dir);

        if (!turned) {
            int nextDir = (dir + 1) % 4;  // one clockwise 90° turn
            res = Math.max(res,
                1 + dfs(grid, i + DIRS[nextDir][0], j + DIRS[nextDir][1], true, nextNum, nextDir)
            );
        }

        return memo[i][j][turnedIdx][hashNum][dir] = res;
    }
}
