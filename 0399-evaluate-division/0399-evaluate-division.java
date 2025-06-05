import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Graph: Node -> Map of adjacent nodes and weights
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Step 1: Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        // Step 2: Answer queries using DFS
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                results[i] = -1.0;
            } else if (src.equals(dst)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, src, dst, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double acc, Set<String> visited) {
        if (curr.equals(target)) return acc;
        visited.add(curr);

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, acc * neighbor.getValue(), visited);
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }
}
