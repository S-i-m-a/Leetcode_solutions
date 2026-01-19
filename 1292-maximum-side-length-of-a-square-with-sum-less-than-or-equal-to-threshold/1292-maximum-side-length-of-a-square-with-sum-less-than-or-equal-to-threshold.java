class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // build 2D prefix sum array (1-indexed)
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        int ans = 0;

        // Binary search for max side length
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFindSquare(prefix, mid, threshold)) {
                ans = mid;      // mid is valid, try larger
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // check if there exists a k x k square with sum <= threshold
    private boolean canFindSquare(int[][] prefix, int k, int threshold) {
        if (k == 0) return true;
        int m = prefix.length - 1;
        int n = prefix[0].length - 1;

        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = prefix[i][j]
                    - prefix[i - k][j]
                    - prefix[i][j - k]
                    + prefix[i - k][j - k];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
