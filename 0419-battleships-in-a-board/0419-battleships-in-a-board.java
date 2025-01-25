class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        int m = board.length;
        int n = board[0].length; // dimensions for board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        // check if cell is a leader
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}