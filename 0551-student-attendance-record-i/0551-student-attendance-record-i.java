public class Solution {
    public boolean checkRecord(String s) {
        // Rule 1: No more than one 'A'
        int absentCount = 0;

        // Loop through the string to count 'A's and check for 'LLL'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
                if (absentCount > 1) {
                    return false; // More than one 'A' is not allowed
                }
            }
            
            // Rule 2: No consecutive 'LLL'
            if (i > 1 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return false; // "LLL" found, so return false
            }
        }
        
        return true; // The record is valid
    }
}
