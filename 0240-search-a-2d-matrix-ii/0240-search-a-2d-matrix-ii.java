class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];
            if (val == target) return true;
            else if (val > target) col--;
            else row++;
        }

        return false;
    }
}
