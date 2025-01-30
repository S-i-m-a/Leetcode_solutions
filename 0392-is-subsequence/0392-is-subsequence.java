class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move s pointer if a match is found
            }
            j++; // Always move t pointer
        }
        return i == s.length();
    }
}
