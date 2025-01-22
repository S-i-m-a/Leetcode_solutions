public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        
        // Traverse both strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move the pointer of s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Move the pointer of t
            j++;
        }
        
        // If we've matched all characters of s
        return i == s.length();
    }
}
