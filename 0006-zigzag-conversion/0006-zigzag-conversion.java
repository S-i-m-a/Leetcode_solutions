class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[index].append(c);

            // Change direction at the first and last row
            if (index == 0 || index == numRows - 1) {
                goingDown = !goingDown;
            }

            index += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
