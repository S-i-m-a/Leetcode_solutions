import java.util.*;

class Solution {
    public int[][] matrixRankTransform(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        int[] row = new int[m], col = new int[n];
        Map<Integer, List<int[]>> map = new TreeMap<>();
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                map.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
        
        int[] parent = new int[m + n];
        for (int key : map.keySet()) {
            Arrays.fill(parent, -1);
            Map<Integer, Integer> rootMap = new HashMap<>();
            for (int[] p : map.get(key)) {
                int a = find(p[0], parent), b = find(p[1] + m, parent);
                if (a != b) parent[a] = b;
            }
            for (int[] p : map.get(key)) {
                int root = find(p[0], parent);
                int max = Math.max(row[p[0]], col[p[1]]);
                rootMap.put(root, Math.max(rootMap.getOrDefault(root, 0), max));
            }
            for (int[] p : map.get(key)) {
                int r = p[0], c = p[1], root = find(r, parent);
                int val = rootMap.get(root) + 1;
                res[r][c] = row[r] = col[c] = val;
            }
        }
        return res;
    }

    int find(int x, int[] p) {
        if (p[x] == -1) return x;
        return p[x] = find(p[x], p);
    }
}
