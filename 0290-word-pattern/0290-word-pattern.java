import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // Split the string into words
        if (pattern.length() != words.length) {
            return false; // Length mismatch
        }
        
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            // Check if the character is already mapped
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }
            
            // Check if the word is already mapped
            if (wordToChar.containsKey(word)) {
                if (!wordToChar.get(word).equals(c)) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        
        return true; // All mappings are consistent
    }
}
