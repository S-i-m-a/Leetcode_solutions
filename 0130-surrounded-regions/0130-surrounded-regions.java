public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // Step 1: Run DFS on the border 'O's
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        
        // Step 2: Flip all surrounded 'O's to 'X' and safe 'O's back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Flip surrounded 'O' to 'X'
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O'; // Restore safe 'O'
                }
            }
        }
    }

    // Helper function to run DFS and mark safe 'O's
    private void dfs(char[][] board, int i, int j) {
        // Boundary check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        // Mark the current 'O' as safe
        board[i][j] = 'S'; // 'S' will be used to mark safe 'O's
        
        // Explore the four directions (up, down, left, right)
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
