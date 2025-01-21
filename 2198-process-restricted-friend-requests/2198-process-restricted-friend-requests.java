import java.util.*;

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);
        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];

            // Check if adding this request violates any restriction
            boolean valid = true;
            int rootU = uf.find(u);
            int rootV = uf.find(v);

            for (int[] restriction : restrictions) {
                int x = restriction[0];
                int y = restriction[1];
                int rootX = uf.find(x);
                int rootY = uf.find(y);

                // If the two groups violate the restriction, mark as invalid
                if ((rootU == rootX && rootV == rootY) || (rootU == rootY && rootV == rootX)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                uf.union(u, v); // Merge the groups if the request is valid
            }

            result[i] = valid;
        }

        return result;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
