import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        
        // Array to store the height of the histogram
        int[] height = new int[n];
        int maxArea = 0;
        
        // Iterate through each row
        for (int i = 0; i < m; i++) {
            // Update the histogram heights for the current row
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++; // Increase the height of the column
                } else {
                    height[j] = 0; // Reset the height if it's a 0
                }
            }

            // Calculate the maximal rectangle area for the current histogram (height array)
            maxArea = Math.max(maxArea, largestRectangleInHistogram(height));
        }
        
        return maxArea;
    }
    
    // Helper function to calculate the largest rectangle area in a histogram
    private int largestRectangleInHistogram(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        
        while (i < height.length) {
            // Push the index of the height to the stack if it's increasing
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                // Calculate the area with the height at the top of the stack
                int h = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
        }
        
        // Calculate the area for remaining bars in the stack
        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * width);
        }
        
        return maxArea;
    }
}
