class Solution {
    // Method name is checkTwoChessboards as per your driver code
    public boolean checkTwoChessboards(String coordinates1, String coordinates2) {
        return (coordinatesToIndex(coordinates1) % 2) == (coordinatesToIndex(coordinates2) % 2);
    }

    private int coordinatesToIndex(String coordinates) {
        // Convert column (e.g., 'a' to 'h') to 0 to 7
        int col = coordinates.charAt(0) - 'a';
        // Convert row (e.g., '1' to '8') to 0 to 7
        int row = coordinates.charAt(1) - '1';
        
        // Return the sum of row and column index
        return col + row;
    }
}
