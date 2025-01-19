public class Solution {
    public String reorderSpaces(String text) {
        // Step 1: Split the text into words
        String[] words = text.trim().split("\\s+");
        
        // Step 2: Count the number of spaces
        int totalSpaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                totalSpaces++;
            }
        }
        
        // Step 3: If there is only one word, return it with all the spaces at the end
        if (words.length == 1) {
            return words[0] + " ".repeat(totalSpaces);
        }
        
        // Step 4: Calculate the number of spaces between words
        int spacesBetweenWords = totalSpaces / (words.length - 1);
        int extraSpaces = totalSpaces % (words.length - 1);
        
        // Step 5: Create the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) {
                result.append(" ".repeat(spacesBetweenWords));
            }
        }
        
        // Step 6: Add the extra spaces at the end
        result.append(" ".repeat(extraSpaces));
        
        return result.toString();
    }
}
