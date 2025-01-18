import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int windowLength = wordLength * wordCount;

        // Step 1: Create a frequency map for words
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Step 2: Traverse the string using sliding window
        for (int i = 0; i < wordLength; i++) { // Start checking at different offsets
            int left = i, right = i, count = 0;
            Map<String, Integer> currentFreq = new HashMap<>();

            while (right + wordLength <= s.length()) {
                // Step 3: Get a word from the sliding window
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordFreq.containsKey(word)) {
                    currentFreq.put(word, currentFreq.getOrDefault(word, 0) + 1);
                    count++;

                    // Step 4: Remove extra occurrences of a word
                    while (currentFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // Step 5: Check if all words are matched
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // If the word is not in words, reset the window
                    currentFreq.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(solution.findSubstring(s, words)); // Output: [0, 9]
    }
}
