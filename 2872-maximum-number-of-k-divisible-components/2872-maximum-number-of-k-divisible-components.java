import java.util.*;

class Solution {
    private int ans;
    private List<Integer>[] graph;
    private int[] values;
    private int k;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        this.ans = 0;

        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(0, -1);
        return ans;
    }

    // Returns subtree sum mod k
    private int dfs(int u, int parent) {
        long sum = values[u];
        for (int v : graph[u]) {
            if (v == parent) continue;
            sum += dfs(v, u);
        }
        sum %= k;
        if (sum == 0) {
            ans++;
        }
        return (int) sum;
    }
}
