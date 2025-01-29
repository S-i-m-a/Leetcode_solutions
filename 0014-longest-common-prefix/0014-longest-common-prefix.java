public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Start by assuming the first string is the longest common prefix
        String prefix = strs[0];
        
        // Compare the prefix with each string
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix from the right until it matches the start of strs[i]
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If there's no common prefix, return an empty string
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}
