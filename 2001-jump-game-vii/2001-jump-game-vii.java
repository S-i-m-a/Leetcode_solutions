public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        visited[0] = true; // We start at index 0
        // Queue to hold indices we can reach
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        int farthest = 0; // Keep track of the farthest index we can jump to so far
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) return false; // No more positions to process
            
            // Get the current position to process from the queue
            int current = queue.poll();
            
            // Calculate the range of valid next jumps from current position
            int start = Math.max(current + minJump, farthest + 1);
            int end = Math.min(current + maxJump, n - 1);
            
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0' && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                    // If we can reach the last index, return true
                    if (j == n - 1) return true;
                }
            }
            
            // Update farthest reachable index
            farthest = end;
        }
        
        return false;
    }
}
