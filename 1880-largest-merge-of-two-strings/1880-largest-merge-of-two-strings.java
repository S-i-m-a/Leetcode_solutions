class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        
        // While both strings have characters left
        while (i < word1.length() && j < word2.length()) {
            // Compare the substrings starting at i and j
            if (word1.substring(i).compareTo(word2.substring(j)) >= 0) {
                result.append(word1.charAt(i));
                i++;
            } else {
                result.append(word2.charAt(j));
                j++;
            }
        }
        
        // Append the remaining characters from either string
        result.append(word1.substring(i));
        result.append(word2.substring(j));
        
        return result.toString();
    }
}
