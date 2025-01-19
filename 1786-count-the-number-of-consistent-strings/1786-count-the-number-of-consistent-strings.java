import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Create a set for allowed characters
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        // Step 2: Initialize the count for consistent strings
        int count = 0;

        // Step 3: Check each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            // Step 4: Check if all characters of the word are in the allowedSet
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            
            // If the word is consistent, increment the count
            if (isConsistent) {
                count++;
            }
        }

        // Step 5: Return the count of consistent strings
        return count;
    }
}
