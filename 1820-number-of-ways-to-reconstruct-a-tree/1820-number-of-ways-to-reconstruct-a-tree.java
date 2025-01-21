import java.util.*;

class Solution {
    public int checkWays(int[][] pairs) {
        // Adjacency list to store all connections
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        // Populate the adjacency list
        for (int[] pair : pairs) {
            adj.putIfAbsent(pair[0], new HashSet<>());
            adj.putIfAbsent(pair[1], new HashSet<>());
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        // Sort nodes by their degree (number of connections) in descending order
        List<Integer> nodes = new ArrayList<>(adj.keySet());
        nodes.sort((a, b) -> adj.get(b).size() - adj.get(a).size());

        int root = nodes.get(0); // Candidate root (highest degree)
        if (adj.get(root).size() != adj.size() - 1) {
            return 0; // If the root doesn't connect to all other nodes, no valid tree
        }

        int result = 1; // 1 means unique reconstruction
        for (int node : nodes) {
            if (node == root) continue; // Skip root

            // Find the parent of the current node in the tree
            int parent = -1;
            int minDegree = Integer.MAX_VALUE;

            for (int neighbor : adj.get(node)) {
                if (adj.get(neighbor).size() < minDegree && adj.get(neighbor).size() >= adj.get(node).size()) {
                    parent = neighbor;
                    minDegree = adj.get(neighbor).size();
                }
            }

            if (parent == -1) {
                return 0; // No valid parent found
            }

            // Check if all connections of `node` are valid in the parent's subtree
            for (int neighbor : adj.get(node)) {
                if (neighbor != parent && !adj.get(parent).contains(neighbor)) {
                    return 0;
                }
            }

            // Check for multiple reconstructions
            if (adj.get(parent).size() == adj.get(node).size()) {
                result = 2; // Multiple ways to reconstruct
            }
        }

        return result;
    }
}
