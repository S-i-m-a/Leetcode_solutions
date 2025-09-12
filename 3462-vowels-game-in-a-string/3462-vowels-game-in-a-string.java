class Solution {
    public boolean doesAliceWin(String s) {
        // Check if there's at least one vowel in the string
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isVowel(char c) {
        // assuming input is lowercase; if not, convert or check both
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
