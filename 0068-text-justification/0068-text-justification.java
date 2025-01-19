import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            // Check if adding this word exceeds the maxWidth
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                // If so, justify the current line and add it to the result
                result.add(justify(currentLine, currentLength, maxWidth));
                currentLine.clear();
                currentLength = 0;
            }

            // Add the word to the current line
            currentLine.add(word);
            currentLength += word.length();
        }

        // Handle the last line (left-justified)
        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < currentLine.size(); i++) {
            lastLine.append(currentLine.get(i));
            if (i != currentLine.size() - 1) {
                lastLine.append(" ");
            }
        }

        // Add remaining spaces at the end
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }

    private String justify(List<String> words, int length, int maxWidth) {
        int spaces = maxWidth - length;
        int gaps = words.size() - 1;

        // If there is only one word, return it left-justified
        if (gaps == 0) {
            return words.get(0) + " ".repeat(spaces);
        }

        // Calculate spaces between words
        int evenSpace = spaces / gaps;
        int extraSpace = spaces % gaps;

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i < gaps) {
                int spaceCount = evenSpace + (i < extraSpace ? 1 : 0);
                line.append(" ".repeat(spaceCount));
            }
        }

        return line.toString();
    }
}
