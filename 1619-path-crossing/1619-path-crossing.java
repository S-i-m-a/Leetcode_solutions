import java.util.HashSet;

public class Solution {
    public boolean isPathCrossing(String path) {
        // Set to store visited points
        HashSet<String> visited = new HashSet<>();
        
        // Starting point at origin (0, 0)
        int x = 0, y = 0;
        
        // Add the starting point to the visited set
        visited.add(x + "," + y);
        
        // Traverse the path
        for (char direction : path.toCharArray()) {
            // Move in the respective direction
            if (direction == 'N') {
                y++;  // Move up
            } else if (direction == 'E') {
                x++;  // Move right
            } else if (direction == 'S') {
                y--;  // Move down
            } else if (direction == 'W') {
                x--;  // Move left
            }
            
            // Check if the new position has already been visited
            if (visited.contains(x + "," + y)) {
                return true; // Path crosses
            }
            
            // Add the new position to the visited set
            visited.add(x + "," + y);
        }
        
        // If no crossing occurs, return false
        return false;
    }
}
