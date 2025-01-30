import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }

            int gaps = last - index - 1;
            StringBuilder line = new StringBuilder();

            if (last == words.length || gaps == 0) { // Left-justified case
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else { // Fully justified case
                int totalSpaces = maxWidth - count + gaps;
                int spaceBetween = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        int spacesToAdd = spaceBetween + (i - index < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}
