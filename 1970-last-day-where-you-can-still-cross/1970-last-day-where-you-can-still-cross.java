class Solution {
    private int[][] cells;
    private int rows;
    private int cols;

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.cells = cells;
        this.rows = row;
        this.cols = col;

        // Binary search for first day where crossing becomes impossible
        int left = 1;
        int right = cells.length;
        int firstTrueIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (feasible(mid)) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Return last day where crossing was still possible
        return firstTrueIndex - 1;
    }

    private boolean feasible(int day) {
        // Returns true when crossing is NOT possible (inverted condition)
        return !canCross(day);
    }

    private boolean canCross(int dayCount) {
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < dayCount; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        final int[] directions = {-1, 0, 1, 0, -1};
        Deque<int[]> queue = new ArrayDeque<>();

        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 0) {
                queue.offer(new int[] {0, c});
                grid[0][c] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int currentRow = position[0];
            int currentCol = position[1];

            if (currentRow == rows - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + directions[i];
                int nextCol = currentCol + directions[i + 1];

                if (nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < cols &&
                    grid[nextRow][nextCol] == 0) {
                    queue.offer(new int[] {nextRow, nextCol});
                    grid[nextRow][nextCol] = 1;
                }
            }
        }

        return false;
    }
}