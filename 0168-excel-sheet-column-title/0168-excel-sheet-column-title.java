class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;  // Adjust for 1-based index
            result.insert(0, (char) ('A' + columnNumber % 26));  // Get the character
            columnNumber /= 26;
        }
        return result.toString();
    }
}
