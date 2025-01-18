public class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any trailing spaces from the string
        s = s.trim();
        
        // Find the length of the last word
        int length = 0;
        int i = s.length() - 1;
        
        // Traverse from the end of the string and count the characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}
