class Solution {
    public String makeLargestSpecial(String s) {
        // Base case: empty string returns empty
        if (s.isEmpty()) {
            return "";
        }
      
        // List to store all special substrings at current level
        List<String> specialSubstrings = new ArrayList<>();
      
        // Counter to track balance of 1s and 0s
        int balance = 0;
      
        // Start index of current special substring
        int startIndex = 0;
      
        // Iterate through the string to find special substrings
        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            // Increment balance for '1', decrement for '0'
            if (s.charAt(currentIndex) == '1') {
                balance++;
            } else {
                balance--;
            }
          
            // When balance returns to 0, we found a complete special substring
            if (balance == 0) {
                // Recursively process the inner content (excluding outer 1 and 0)
                String innerContent = makeLargestSpecial(
                    s.substring(startIndex + 1, currentIndex)
                );
              
                // Reconstruct the special substring with processed inner content
                String specialString = "1" + innerContent + "0";
                specialSubstrings.add(specialString);
              
                // Move start index to begin next special substring search
                startIndex = currentIndex + 1;
            }
        }
      
        // Sort all special substrings in descending order (lexicographically largest first)
        specialSubstrings.sort(Comparator.reverseOrder());
      
        // Concatenate all sorted special substrings to form the result
        return String.join("", specialSubstrings);
    }
}