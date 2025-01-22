class Solution {
    public boolean isAnagram(String s, String t) {
        // If the lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Create an array to count the frequency of characters (26 letters in the alphabet)
        int[] count = new int[26];
        
        // Count the frequency of characters in string s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Subtract the frequency based on string t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            // If the count goes negative, it's not an anagram
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        
        // All counts should be zero if it's a valid anagram
        return true;
    }
}
