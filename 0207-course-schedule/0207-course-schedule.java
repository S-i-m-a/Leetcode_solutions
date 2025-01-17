import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph and in-degree array
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Initialize a queue and add courses with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process courses using BFS
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;
            
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all courses can be completed
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Can finish all courses? " + solution.canFinish(numCourses, prerequisites));
    }
}
