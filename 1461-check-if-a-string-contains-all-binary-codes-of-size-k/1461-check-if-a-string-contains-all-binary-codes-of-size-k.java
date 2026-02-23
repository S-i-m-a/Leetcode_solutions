class Solution {
    public boolean hasAllCodes(String s, int k) {
        int stringLength = s.length();
        // Calculate total number of possible k-bit binary codes (2^k)
        int totalPossibleCodes = 1 << k;
      
        // Early termination: if string doesn't have enough substrings, return false
        // Number of k-length substrings = stringLength - k + 1
        if (stringLength - k + 1 < totalPossibleCodes) {
            return false;
        }
      
        // Use HashSet to store unique k-length substrings
        Set<String> uniqueSubstrings = new HashSet<>();
      
        // Iterate through all possible k-length substrings
        for (int i = 0; i <= stringLength - k; i++) {
            // Extract substring from index i to i+k (exclusive)
            String currentSubstring = s.substring(i, i + k);
            uniqueSubstrings.add(currentSubstring);
        }
      
        // Check if we found all possible k-bit binary codes
        return uniqueSubstrings.size() == totalPossibleCodes;
    }
}
