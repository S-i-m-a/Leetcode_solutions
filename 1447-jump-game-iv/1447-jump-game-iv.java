import java.util.*;

public class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        if (n == 1) return 0; // Already at the last index
        
        // A map to store indices of the same value in the array
        Map<Integer, List<Integer>> valueIndices = new HashMap<>();
        
        // Populate the map with indices of the same values
        for (int i = 0; i < n; i++) {
            valueIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        // BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // Start BFS from index 0
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // If we reach the last index, return the number of steps
                if (current == n - 1) {
                    return steps;
                }
                
                // Jump to index i + 1
                if (current + 1 < n && !visited[current + 1]) {
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }
                
                // Jump to index i - 1
                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }
                
                // Jump to any index j where arr[current] == arr[j]
                if (valueIndices.containsKey(arr[current])) {
                    for (int j : valueIndices.get(arr[current])) {
                        if (j != current && !visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    // Once we've processed all indices for the current value, remove the list
                    valueIndices.remove(arr[current]);
                }
            }
            // Increment steps after processing one level of BFS
            steps++;
        }
        
        return -1; // If we cannot reach the last index (though it's guaranteed we can in the problem)
    }
}
