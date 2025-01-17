import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        // Result array to store the course order
        int[] order = new int[numCourses];
        int index = 0;
        
        // Process courses using BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If not all courses are processed, return an empty array
        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Course order: " + Arrays.toString(solution.findOrder(numCourses, prerequisites)));
    }
}
