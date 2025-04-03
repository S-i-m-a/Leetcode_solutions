import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for (String word : wordCount.keySet()) {
            if (isSubsequence(word, s)) {
                count += wordCount.get(word);
            }
        }
        return count;
    }

    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
