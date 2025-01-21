import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // Edge case: if either string is empty, return an empty string
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Frequency map to count characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window pointers and variables to track the window
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredChars = tFreq.size();
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Start sliding the window
        while (right < s.length()) {
            // Add character at 'right' to the window
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if this character meets the required frequency
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                requiredChars--;
            }

            // Try to shrink the window from the left if it contains all characters of t
            while (requiredChars == 0) {
                // Update the minimum window if the current window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Remove the character at 'left' from the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    requiredChars++;
                }

                left++;  // Shrink the window from the left
            }

            right++;  // Expand the window from the right
        }

        // Return the minimum window, or an empty string if no valid window found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
