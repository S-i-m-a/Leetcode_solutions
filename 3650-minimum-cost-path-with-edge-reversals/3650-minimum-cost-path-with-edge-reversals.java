import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add original and reversed edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            // Original direction: u -> v with cost w
            graph[u].add(new int[]{v, w});
            // Reversed direction: v -> u with cost 2 * w
            graph[v].add(new int[]{u, 2 * w});
        }

        // Distance array and initial values
        final int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        // Min-heap for Dijkstra: {currentCost, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], node = current[1];

            // If we have a better already, skip
            if (cost > dist[node]) continue;
            // If reached destination
            if (node == n - 1) return cost;

            // Relax edges
            for (int[] next : graph[node]) {
                int nxtNode = next[0], wgt = next[1];
                int newCost = cost + wgt;
                if (newCost < dist[nxtNode]) {
                    dist[nxtNode] = newCost;
                    pq.offer(new int[]{newCost, nxtNode});
                }
            }
        }

        return -1;  // unreachable
    }
}
