class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                // Build histogram
                if (row[i] == '1') {
                    heights[i]++;
                } else {
                    heights[i] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1); // add 0 height to flush the stack

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
