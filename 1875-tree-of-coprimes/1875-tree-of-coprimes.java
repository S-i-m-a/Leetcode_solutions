import java.util.*;

class Solution {
    List<Integer>[] g = new ArrayList[51];
    List<Integer>[] tree;
    int[] res;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        for (int i = 1; i <= 50; i++) g[i] = new ArrayList<>();
        for (int i = 1; i <= 50; i++)
            for (int j = 1; j <= 50; j++)
                if (gcd(i, j) == 1) g[i].add(j);

        int n = nums.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        res = new int[n];
        Map<Integer, int[]> map = new HashMap<>();
        dfs(0, -1, 0, nums, map);
        return res;
    }

    void dfs(int u, int p, int d, int[] nums, Map<Integer, int[]> map) {
        int ans = -1, maxD = -1;
        for (int val : g[nums[u]]) {
            if (map.containsKey(val) && map.get(val)[1] > maxD) {
                ans = map.get(val)[0];
                maxD = map.get(val)[1];
            }
        }
        res[u] = ans;
        int[] prev = map.put(nums[u], new int[]{u, d});
        for (int v : tree[u]) if (v != p) dfs(v, u, d + 1, nums, map);
        if (prev != null) map.put(nums[u], prev); else map.remove(nums[u]);
    }

    int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
