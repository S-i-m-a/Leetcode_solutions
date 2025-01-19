class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // Initialize with the base case for n = 0 (just [0])
        result.add(0);
        
        // Iterate to generate the Gray code sequence for n bits
        for (int i = 0; i < n; i++) {
            int currentSize = result.size();
            // For each bit, generate the new numbers by prefixing `1` to the existing sequence
            for (int j = currentSize - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << i));  // Prefix `1` to the current number
            }
        }
        
        return result;
    }
}
