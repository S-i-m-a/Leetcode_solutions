class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                // If characters match, move both pointers
                i++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                // If characters don't match and the current typed character
                // is not a long press (i.e., not the same as the previous character), return false
                return false;
            }
            j++;
        }
        
        // Ensure we've completely traversed `name`
        return i == name.length();
    }
}
