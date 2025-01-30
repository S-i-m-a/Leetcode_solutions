import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and is within the window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // Move the left pointer to one past the last occurrence of currentChar
                left = map.get(currentChar) + 1;
            }

            // Update the position of the current character
            map.put(currentChar, right);

            // Calculate the window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
