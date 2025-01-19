import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Step 1: Process each word in the list
        for (String word : words) {
            // Create a unique key by representing the character set of the word
            char[] chars = new char[26];
            for (char c : word.toCharArray()) {
                chars[c - 'a'] = 1;  // Mark the characters present in the word
            }
            String key = new String(chars);  // Convert the char array into a key string
            
            // Step 2: Store the frequency of each unique key
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        // Step 3: Count the number of similar pairs
        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq > 1) {
                count += freq * (freq - 1) / 2;  // Combination of 2 from 'freq' items
            }
        }

        // Step 4: Return the total count of similar pairs
        return count;
    }
}
