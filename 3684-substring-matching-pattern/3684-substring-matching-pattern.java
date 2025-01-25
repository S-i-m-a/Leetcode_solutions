class Solution {
    public boolean hasMatch(String s, String p) {
        // Initialize the starting index in the string s
        int currentIndex = 0;
      
        // Split the pattern p by '*' and iterate over each substring
        for (String subPattern : p.split("\\*")) {
            // Find the index of the current subPattern in s starting from currentIndex
            int matchIndex = s.indexOf(subPattern, currentIndex);
          
            // If subPattern is not found in s, return false
            if (matchIndex == -1) {
                return false;
            }
          
            // Update currentIndex to the end of the matched subPattern
            currentIndex = matchIndex + subPattern.length();
        }
      
        // All subPatterns were found in sequence, hence return true
        return true;
    }
}