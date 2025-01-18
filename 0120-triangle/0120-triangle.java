public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Start from the second-to-last row and move upwards
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Update the current element with the minimum of the two adjacent elements below
                int minAdjacent = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, triangle.get(row).get(col) + minAdjacent);
            }
        }
        
        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }
}
