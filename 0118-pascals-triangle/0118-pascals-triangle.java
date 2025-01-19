class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base case: the first row is always [1]
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            
            // Fill in the inner elements of the row
            for (int j = 1; j < i; j++) {
                row.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            
            // Add the row to the result
            result.add(row);
        }
        
        return result;
    }
}
