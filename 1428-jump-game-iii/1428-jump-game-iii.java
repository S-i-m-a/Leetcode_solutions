public class Solution {
    public boolean canReach(int[] arr, int start) {
        // Edge case: if the starting index is already 0, return true
        if (arr[start] == 0) return true;
        
        // Use a visited array to keep track of visited indices
        boolean[] visited = new boolean[arr.length];
        
        // Perform DFS starting from the start index
        return dfs(arr, start, visited);
    }
    
    private boolean dfs(int[] arr, int current, boolean[] visited) {
        // If the current index is out of bounds or already visited, return false
        if (current < 0 || current >= arr.length || visited[current]) {
            return false;
        }
        
        // Mark the current index as visited
        visited[current] = true;
        
        // If we've reached an index with value 0, return true
        if (arr[current] == 0) {
            return true;
        }
        
        // Explore the next possible jumps: forward and backward
        return dfs(arr, current + arr[current], visited) || dfs(arr, current - arr[current], visited);
    }
}
