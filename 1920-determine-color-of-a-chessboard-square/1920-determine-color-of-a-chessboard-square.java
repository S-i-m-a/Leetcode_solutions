class Solution {
    public boolean squareIsWhite(String coordinates) {
        // Convert the column ('a' to 'h') to a number (0 to 7)
        int col = coordinates.charAt(0) - 'a';
        // Convert the row ('1' to '8') to a number (1 to 8), then subtract 1 to make it 0-indexed
        int row = coordinates.charAt(1) - '1';
        
        // The color is determined by the parity of the sum of row and column
        return (col + row) % 2 != 0;
    }
}
