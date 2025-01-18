import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create a map to count the frequency of each character in the magazine
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Count frequencies of characters in the magazine
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Check if there are enough characters in the magazine to form the ransom note
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;  // If the character is missing or not enough occurrences, return false
            }
            map.put(c, map.get(c) - 1);  // Decrease the count for the character in the map
        }
        
        return true;  // All characters in ransomNote can be formed from magazine
    }
}
