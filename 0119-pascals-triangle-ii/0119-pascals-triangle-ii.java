class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Initialize the row with 1s, as the first row starts with a single 1
        row.add(1);
        
        // Compute the values for the row
        for (int i = 1; i <= rowIndex; i++) {
            // Start from the rightmost element and update in-place
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1); // Add the last element which is always 1
        }
        
        return row;
    }
}
