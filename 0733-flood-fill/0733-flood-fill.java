class Solution {

    private int[] directions = {-1, 0, 1, 0, -1};
    private int[][] image;
    private int newColor;
    private int originalColor;

    public int[][] floodFill(int[][] image, int startRow, int startColumn, int color) {
        this.image = image;
        this.newColor = color;
        this.originalColor = image[startRow][startColumn];
        dfs(startRow, startColumn);
        return image;
    }

    private void dfs(int row, int column) {
        if (row < 0 || row >= image.length || column < 0 || column >= image[0].length || 
            image[row][column] != originalColor || image[row][column] == newColor) {
            return;
        }
      
        image[row][column] = newColor;
      
        for (int k = 0; k < 4; ++k) {
            dfs(row + directions[k], column + directions[k + 1]);
        }
    }
}
