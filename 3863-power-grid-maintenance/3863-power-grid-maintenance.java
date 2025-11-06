import java.util.*;

class Solution {
    void dfs(int u, List<List<Integer>> adj, int gId, int[] groups, boolean[] seen) {
        seen[u] = true;
        groups[u] = gId;
        for (int v : adj.get(u)) {
            if (!seen[v]) {
                dfs(v, adj, gId, groups, seen);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : connections) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] seen = new boolean[c + 1];
        int[] groups = new int[c + 1];
        Arrays.fill(groups, -1);

        int compCount = 0;
        for (int i = 1; i <= c; i++) {
            if (!seen[i]) {
                dfs(i, adj, compCount, groups, seen);
                compCount++;
            }
        }

        List<TreeSet<Integer>> st = new ArrayList<>();
        for (int i = 0; i < compCount; i++) {
            st.add(new TreeSet<>());
        }

        for (int i = 1; i <= c; i++) {
            st.get(groups[i]).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> ansList = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int g = groups[x];

            if (type == 2) {
                if (online[x]) {
                    online[x] = false;
                    st.get(g).remove(x);
                }
            } else {
                if (online[x]) {
                    ansList.add(x);
                } else {
                    if (st.get(g).isEmpty()) {
                        ansList.add(-1);
                    } else {
                        ansList.add(st.get(g).first());
                    }
                }
            }
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
