class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSquared = 0;
        int maxArea = 0;

        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];
            int diagonalSq = length * length + width * width;
            int area = length * width;

            if (diagonalSq > maxDiagonalSquared) {
                maxDiagonalSquared = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonalSquared) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
