import java.util.*;

class Solution {
    public int maxStarSum(int[] values, int[][] edges, int k) {
        int n = values.length;
        
        // Adjacency list for storing neighbors' weights
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }

        // Populate the adjacency list with neighbors' values
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            neighbors.get(u).add(values[v]);
            neighbors.get(v).add(values[u]);
        }

        int maxSum = Integer.MIN_VALUE;

        // Calculate the star sum for each node
        for (int i = 0; i < n; i++) {
            List<Integer> currentNeighbors = neighbors.get(i);

            // Sort neighbors in descending order
            currentNeighbors.sort(Collections.reverseOrder());

            int starSum = values[i]; // Include the central node's value
            for (int j = 0; j < Math.min(k, currentNeighbors.size()); j++) {
                if (currentNeighbors.get(j) > 0) {
                    starSum += currentNeighbors.get(j); // Add positive neighbors
                } else {
                    break; // Ignore non-positive values
                }
            }

            // Update the maximum star sum
            maxSum = Math.max(maxSum, starSum);
        }

        return maxSum;
    }
}
