import java.util.*;

class Solution {
    static final int DRAW = 0, MOUSE = 1, CAT = 2;

    public int catMouseGame(int[][] g) {
        int n = g.length;
        int[][][] res = new int[n][n][2], deg = new int[n][n][2];
        Queue<int[]> q = new LinkedList<>();

        for (int m = 0; m < n; ++m)
            for (int c = 0; c < n; ++c) {
                deg[m][c][0] = g[m].length;
                deg[m][c][1] = (int) Arrays.stream(g[c]).filter(k -> k != 0).count();
            }

        for (int i = 1; i < n; ++i) {
            res[0][i][0] = res[0][i][1] = MOUSE;
            res[i][i][0] = res[i][i][1] = CAT;
            q.offer(new int[]{0, i, 0, MOUSE});
            q.offer(new int[]{0, i, 1, MOUSE});
            q.offer(new int[]{i, i, 0, CAT});
            q.offer(new int[]{i, i, 1, CAT});
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int m = curr[0], c = curr[1], turn = curr[2], winner = curr[3];

            for (int[] prev : prevStates(g, m, c, turn)) {
                int pm = prev[0], pc = prev[1], pt = prev[2];
                if (res[pm][pc][pt] > 0) continue;

                boolean good = (winner == MOUSE && pt == 0) || (winner == CAT && pt == 1);
                if (good) {
                    res[pm][pc][pt] = winner;
                    q.offer(new int[]{pm, pc, pt, winner});
                } else {
                    if (--deg[pm][pc][pt] == 0) {
                        res[pm][pc][pt] = winner;
                        q.offer(new int[]{pm, pc, pt, winner});
                    }
                }
            }
        }

        return res[1][2][0];
    }

    List<int[]> prevStates(int[][] g, int m, int c, int turn) {
        List<int[]> list = new ArrayList<>();
        if (turn == 0) {
            for (int pc : g[c]) if (pc != 0) list.add(new int[]{m, pc, 1});
        } else {
            for (int pm : g[m]) list.add(new int[]{pm, c, 0});
        }
        return list;
    }
}
