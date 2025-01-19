import java.util.*;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // Initialize Union-Find (Disjoint Set Union) data structure
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        // Union the indices in each pair
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        // Create a map to store the characters at each connected component
        Map<Integer, PriorityQueue<Character>> componentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            componentMap.putIfAbsent(root, new PriorityQueue<>());
            componentMap.get(root).offer(s.charAt(i)); // Add the character to the corresponding component
        }

        // Reconstruct the string by getting the smallest characters from the PriorityQueue
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            result.append(componentMap.get(root).poll()); // Poll the smallest character
        }

        return result.toString();
    }

    // Union-Find data structure to manage connected components
    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Initially, each element is its own parent
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
                parent[rootX] = rootY; // Union the sets
            }
        }
    }
}
