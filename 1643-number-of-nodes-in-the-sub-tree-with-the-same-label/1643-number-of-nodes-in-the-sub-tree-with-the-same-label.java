import java.util.*;

public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        int[] ans = new int[n];
        dfs(0, -1, tree, labels, ans);
        return ans;
    }

    private int[] dfs(int u, int parent, List<List<Integer>> tree,
                      String labels, int[] ans) {
        int[] count = new int[26];
        for (int v : tree.get(u)) {
            if (v == parent) continue;
            int[] childCount = dfs(v, u, tree, labels, ans);
            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }
        int idx = labels.charAt(u) - 'a';
        count[idx]++;
        ans[u] = count[idx];
        return count;
    }
}
