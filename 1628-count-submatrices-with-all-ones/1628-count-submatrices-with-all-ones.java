class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int ans = 0;
        int[] height = new int[n];
        
        for (int r = 0; r < m; r++) {
            // Build histogram: number of continuous 1s ending at current row
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 1) height[c]++;
                else height[c] = 0;
            }
            ans += countSubmatricesInHistogram(height);
        }
        
        return ans;
    }
    
    // Counts submatrices ending at this row using a monotonic stack
    private int countSubmatricesInHistogram(int[] h) {
        int n = h.length;
        Stack<int[]> stack = new Stack<>();
        int count = 0, sum = 0;
        
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= h[i]) {
                int[] top = stack.pop();
                int height = top[0], c = top[1];
                cnt += c;
                sum -= height * c;
            }
            sum += h[i] * cnt;
            stack.push(new int[]{h[i], cnt});
            count += sum;
        }
        
        return count;
    }
}
