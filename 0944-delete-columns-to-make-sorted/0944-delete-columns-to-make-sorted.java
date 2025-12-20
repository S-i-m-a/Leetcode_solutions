class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int deleteCount = 0;

        // Check each column
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                // If out of order in this column, delete it
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }
}
